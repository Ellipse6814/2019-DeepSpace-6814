package frc.robot.subsystems;

import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Const;
import frc.robot.Util.ArmState;
import frc.robot.Util.MotorDirection;
import frc.robot.Util.TalonHelper;
import frc.robot.commands.DoNothing;
import frc.robot.log.Logger;

public class Arm extends Subsystem {

    private static Arm instance;
    public ArmState state;
    // private Logger logger = Logger.getInstance()

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private DigitalInput armHallEffectFront = new DigitalInput(Const.kArmHallEffectFrontSensorPort);
    private DigitalInput armHallEffectBack = new DigitalInput(Const.kArmHallEffectBackSensorPort);

    public TalonSRX armMotor;
    private VictorSPX armMotorSlave;

    private boolean isReset = false;

    private Arm() {
        initTalons();
    }

    private void initTalons() {
        armMotor = TalonHelper.createTalon(Const.kArmMotorPort, Const.kArmMotorInverted);

        TalonHelper.configCurrentLimit(armMotor, Const.kArmMotorMaxAmp);
        armMotorSlave = TalonHelper.createSlaveVictor(Const.kArmMotorSlavePort, armMotor);

        TalonHelper.configQuadEncoder(armMotor, Const.kArmEncoderInverted);

        // armm

        TalonHelper.configPID(armMotor, 0, Const.kArmkP, Const.kArmkI, Const.kArmkD, Const.kArmkF);

        // armMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10,
        // 10);

        TalonHelper.configLowerSoftLimit(armMotor,
                (int) (Const.kArmLowerSoftLimit * Const.kArmGearRatioArm2Encoder * Const.kArmDeg2Talon4096Unit));
        TalonHelper.configUpperSoftLimit(armMotor,
                (int) (Const.kArmUpperSoftLimit * Const.kArmGearRatioArm2Encoder * Const.kArmDeg2Talon4096Unit));

        // Output Encoder Values
        System.out.println("Left Encoder Position" + armMotor.getSelectedSensorPosition(0));
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        // TalonHelper.configPID(armMotor, 0, Const.kArmkP, Const.kArmkI, Const.kArmkD, Const.kArmkF);
        if (!isReset) {
            System.out.println("ARM NOT RESETTED. ROBOT WILL NOT MOVE ARM AS PID WILL DESTROY IT.");
            armMotor.set(ControlMode.PercentOutput, 0);
            return;
        }
        double targetPositionRotations = angle * Const.kArmDeg2Talon4096Unit * Const.kArmGearRatioArm2Encoder;
        System.out.println("setting PID setpoint " + targetPositionRotations);
        armMotor.set(ControlMode.Position, targetPositionRotations);
    }

    public void set(ArmState wantedState) {
        if (state == wantedState)
            return;

        state = wantedState;
        setAngle(Const.calcArmAngle(wantedState));
    }

    public void setOpenLoop(double speed, MotorDirection direction) {
        SmartDashboard.putNumber("raw spd", speed);
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
        // return armMotor.getSelectedSensorPosition(0) * Const.kTalon4096Unit2Deg *
        // Const.kArmGearRatioEncoder2Arm;
        SmartDashboard.putNumber("Raw Encoder Value", armMotor.getSelectedSensorPosition(0));
        return armMotor.getSelectedSensorPosition(0) * Const.kArmTalon4096Unit2Deg * Const.kArmGearRatioEncoder2Arm;
    }

    public double getPIDError() {
        return armMotor.getClosedLoopError(0);// * Const.kArmTalon4096Unit2Deg * Const.kArmGearRatioEncoder2Arm;
    }

    public void resetEncoder() {
        armMotor.setSelectedSensorPosition(0);
    }

    public boolean onTarget() {
        return Math.abs(Const.calcArmAngle(state) - getEncoderPosition()) < Const.kArmPIDTolerance;
    }

    /**
     * Disables Backwards EMF on all arm motors. This will cause all motors to
     * coast. This is used in disabled mode when humans try to move the arm
     */
    public void disable() {
        TalonHelper.configNeutralMode(Arrays.asList(armMotor, armMotorSlave), NeutralMode.Coast);
    }

    /**
     * Enables Backwards EMF on all arm motors. This will cause all motors to brake.
     * This is used during competition
     */
    public void enable() {
        TalonHelper.configNeutralMode(Arrays.asList(armMotor, armMotorSlave), NeutralMode.Brake);
    }

    public void resetPeriodic() {
        if (!getFrontHallEffect()) {
            resetEncoder();
            isReset = true;
        }
    }

    public boolean isReset() {
        return isReset;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DoNothing(this)); // Do nothing with this subsystem, but still require it
    }
}
