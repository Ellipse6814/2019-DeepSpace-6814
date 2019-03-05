package frc.robot.subsystems;

import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.JawState;
import frc.robot.Util.MotorDirection;
import frc.robot.Util.TalonHelper;
import frc.robot.commands.DoNothing;

public class Jaw extends Subsystem {

    private static Jaw instance;
    public JawState state;

    public static Jaw getInstance() {
        if (instance == null) {
            instance = new Jaw();
        }
        return instance;
    }

    private TalonSRX jawAngleMotor;

    private DigitalInput jawHallEffect = new DigitalInput(Const.kJawHallEffectSensorPort);

    private Jaw() {
        initTalons();
    }

    private void initTalons() {
        jawAngleMotor = TalonHelper.createTalon(Const.kJawAngleMotorPort, Const.kJawAngleMotorInverted);
        TalonHelper.configCurrentLimit(jawAngleMotor, Const.kJawMotorMaxAmp);
        TalonHelper.configMagEncoder(jawAngleMotor, Const.kJawEncoderInverted);
        TalonHelper.configPID(jawAngleMotor, 0, Const.kJawkP, Const.kJawkI, Const.kJawkD, Const.kJawkF);
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = angle * Const.kDeg2Talon4096Unit * Const.kJawGearRatioJaw2Encoder;
        jawAngleMotor.set(ControlMode.Position, targetPositionRotations);
    }

    public void set(JawState wantedState) {
        if (state == wantedState)
            return;
        state = wantedState;
        setAngle(Const.calcJawAngle(wantedState));
    }

    public void setOpenLoop(double speed, MotorDirection direction) {
        if (direction == MotorDirection.Forward) {
            jawAngleMotor.set(ControlMode.PercentOutput, speed);
        } else {
            jawAngleMotor.set(ControlMode.PercentOutput, -speed);
        }
    }

    public boolean getHallEffect() {
        return jawHallEffect.get();
    }

    public void resetEncoder() {
        jawAngleMotor.setSelectedSensorPosition(0);
    }

    public double getEncoderPosition() {
        return jawAngleMotor.getSelectedSensorPosition(0) * Const.kTalon4096Unit2Deg * Const.kJawGearRatioEncoder2Jaw;
    }

    public double getPIDError() {
        return jawAngleMotor.getClosedLoopError(0) * Const.kTalon4096Unit2Deg * Const.kJawGearRatioEncoder2Jaw;
    }

    public boolean onTarget() {
        return Math.abs(Const.calcJawAngle(state) - getEncoderPosition()) < Const.kJawPIDTolerance;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DoNothing(this)); // Do nothing with this subsystem, but still require it
    }

    public void disable() {
        TalonHelper.configNeutralMode(Arrays.asList(jawAngleMotor), NeutralMode.Coast);
    }

    public void enable() {
        TalonHelper.configNeutralMode(Arrays.asList(jawAngleMotor), NeutralMode.Brake);
    }
}
