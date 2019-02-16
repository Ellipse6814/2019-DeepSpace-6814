package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.ArmState;
import frc.robot.Util.MotorDirection;
import frc.robot.Util.TalonHelper;
import frc.robot.commands.DoNothing;

public class Arm extends Subsystem {

    private static Arm instance;
    public ArmState state;

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private DigitalInput armHallEffectFront = new DigitalInput(Const.kArmHallEffectFrontSensorPort);
    private DigitalInput armHallEffectBack = new DigitalInput(Const.kArmHallEffectBackSensorPort);

    private TalonSRX armMotor;
    private VictorSPX armMotorSlave;

    private Arm() {
        initTalons();
    }

    private void initTalons() {
        armMotor = TalonHelper.createTalon(Const.kArmMotorPort, Const.kArmMotorInverted);

        TalonHelper.configCurrentLimit(armMotor, 30);
        armMotorSlave = TalonHelper.createSlaveVictor(Const.kArmMotorSlavePort, armMotor);

        TalonHelper.configQuadEncoder(armMotor, Const.kArmEncoderInverted);

        TalonHelper.configPID(armMotor, 0, 3, 0, 0, 0);

        // armMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10,
        // 10);

        // Output Encoder Values
        System.out.println("Left Encoder Position" + armMotor.getSelectedSensorPosition(0));
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = Const.deg2Talon4096Unit(angle);
        armMotor.set(ControlMode.Position, targetPositionRotations);
    }

    public void set(ArmState wantedState) {
        if (state == wantedState)
            return;

        state = wantedState;
        setAngle(Const.calcArmAngle(wantedState));
    }

    public void setOpenLoop(double speed, MotorDirection direction) {
        if (direction == MotorDirection.Forward) {
            armMotor.set(ControlMode.PercentOutput, speed);
        } else {
            armMotor.set(ControlMode.PercentOutput, -speed);
        }
    }

    public boolean getFrontHallEffect() {
        return armHallEffectFront.get();
    }

    public boolean getBackHallEffect() {
        return armHallEffectBack.get();
    }

    public double getEncoderPosition() {
        return Const.talon4096Unit2Deg(armMotor.getSelectedSensorPosition(0));
    }

    public double getPIDError() {
        return Const.talon4096Unit2Deg(armMotor.getClosedLoopError(0));
    }

    public void resetEncoder() {
        armMotor.setSelectedSensorPosition(0);
    }

    public boolean onTarget() {
        return Math.abs(Const.calcArmAngle(state) - getEncoderPosition()) < Const.kArmPIDTolerance;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DoNothing(this)); // Do nothing with this subsystem, but still require it
    }
}
