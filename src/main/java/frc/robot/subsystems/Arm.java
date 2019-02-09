package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Enums.ArmState;
import frc.robot.Enums.MotorDirection;

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
        armMotor = new TalonSRX(Const.kArmMotorPort);
        armMotor.setInverted(false);
        armMotor.enableVoltageCompensation(true);
        armMotor.configContinuousCurrentLimit(30, 100);
        armMotor.configPeakCurrentLimit(0);
        armMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, 10);

        armMotorSlave = new VictorSPX(Const.kArmMotorSlavePort);
        armMotorSlave.follow(armMotor);
        armMotorSlave.setInverted(InvertType.FollowMaster);
        armMotorSlave.enableVoltageCompensation(true);

        // Config encoder
        // armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
        // 0, 10);
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
        armMotor.setSensorPhase(true);

        // Config PID
        armMotor.config_kP(0, 2, 10);
        armMotor.config_kI(0, 0, 10);
        armMotor.config_kD(0, 0, 10);
        armMotor.config_kF(0, 1, 10);

        // Output Encoder Values
        System.out.println("Left Encoder Position" + armMotor.getSelectedSensorPosition(0));
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = Const.deg2Talon4096Unit(angle);
        armMotor.set(ControlMode.Position, targetPositionRotations);
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
        return armMotor.getClosedLoopError(0);
    }

    public void resetEncoder() {
        armMotor.setSelectedSensorPosition(0);
    }

    public boolean onTarget() {
        return false; // TODO: stub
    }

    // public void setArmFront() {
    // setArmAngle(Const.kArmSetpointDegFront);
    // }

    // public void setArmBack() {
    // setArmAngle(Const.kArmSetpointDegBack);
    // }

    // public void setArmMiddle() {
    // setArmAngle(Const.kArmSetpointDegMiddle);
    // }

    // public void setArmCustom(double angle) {
    // setArmAngle(angle);
    // }

    @Override
    public void initDefaultCommand() {

    }
}
