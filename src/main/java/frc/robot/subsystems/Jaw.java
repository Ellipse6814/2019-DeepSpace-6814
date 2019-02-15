package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.JawState;
import frc.robot.Util.MotorDirection;

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
        jawAngleMotor = new TalonSRX(Const.kJawAngleMotorPort);
        jawAngleMotor.setInverted(false);
        jawAngleMotor.enableVoltageCompensation(true);
        jawAngleMotor.configContinuousCurrentLimit(30, 100);
        jawAngleMotor.configPeakCurrentLimit(0);
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = Const.deg2Talon4096Unit(angle);
        jawAngleMotor.set(ControlMode.Position, targetPositionRotations);
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

    public boolean onTarget() {
        return false; // TODO: stub
    }

    // public void setJawFront() {
    // setAngle(Const.kJawSetpointDegFront);
    // }

    // public void setJawBack() {
    // setAngle(Const.kJawSetpointDegBack);
    // }

    // public void setJawMiddle() {
    // setAngle(Const.kJawSetpointDegMiddle);
    // }

    // public void setJawCustom(double angle) {
    // setAngle(angle);
    // }

    @Override
    public void initDefaultCommand() {

    }
}
