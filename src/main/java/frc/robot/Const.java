package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Util.ArmState;
import frc.robot.Util.JawState;
import frc.robot.Util.LEDState;

public class Const {
    // ======================== UNIT CONVERSIONS: ==========================
    /** To use: multiply variable with the constant below */
    public static final double deg2Talon4096Unit = 1 / 360.0 * 4096.0;
    public static final double talon4096Unit2Deg = 1 / deg2Talon4096Unit;

    // ============================= GENERAL: ==============================

    public static final int kTalonCommTimeout = 10; // ms

    // ============================= WIRING: ===============================

    // Pneumatic
    public static final int kIntakeSolenoidPort1 = 0;
    public static final int kIntakeSolenoidPort2 = 1;

    public static final Value kHatchIntakeOpenPos = Value.kForward; // TODO
    public static final Value kHatchIntakeClosePos = Value.kReverse;// TODO

    // Hall Effect sensors
    public static final int kJawHallEffectSensorPort = 0;// TODO
    public static final int kArmHallEffectFrontSensorPort = 1;// TODO
    public static final int kArmHallEffectBackSensorPort = 2;// TODO

    // motors (inverts)
    public static final int kJawAngleMotorPort = 3;
    public static final boolean kJawAngleMotorInverted = false;// TODO

    public static final int kIntakeRollerMotorPort = 4;
    public static final boolean kIntakeRollerMotorInverted = false;// TODO

    public static final int kArmMotorPort = 3;
    public static final boolean kArmMotorInverted = false;// TODO
    public static final int kArmMotorSlavePort = 3;

    public static final int kDriveLeftMasterMotorPort = 1;
    public static final boolean kDriveLeftMasterMotorInverted = false;// TODO
    public static final int kDriveRightMasterMotorPort = 2;
    public static final boolean kDriveRightMasterMotorInverted = true;// TODO
    public static final int kDriveLeftSlaveMotorPort = 1;
    public static final int kDriveRightSlaveMotorPort = 2;

    public static final int kLEDPort = 0;

    // Encoder inverts
    public static final boolean kArmEncoderInverted = false;// TODO
    public static final boolean kJawEncoderInverted = false;// TODO
    public static final boolean kDriveLeftEncoderInverted = false;// TODO
    public static final boolean kDriveRightEncoderInverted = true;// TODO

    // Current Limits

    public static final int kDriveMotorMaxAmp = 50; // 50A
    public static final int kArmMotorMaxAmp = 50;
    public static final int kJawMotorMaxAmp = 30;

    // ======================== ENCODER PRESET POSITIONS: ==========================

    // ------------------- ARM --------------------------
    public static final double kArmGearRatioEncoder2Arm = 1; // to use, multiple var with this const //TODO
    public static final double kArmGearRatioArm2Encoder = 1 / kArmGearRatioEncoder2Arm;

    public static final double kArmPIDTolerance = 5;// degs//TODO

    public static double kArmkP = 0.0001;// TODO
    public static double kArmkI = 0;// TODO
    public static double kArmkD = 0;// TODO
    public static double kArmkF = 0;// TODO

    public static double calcArmAngle(ArmState state) {
        double angle;
        if (state == ArmState.FrontBallFloorIn)
            angle = 0; // TODO
        else if (state == ArmState.FrontBallHumanIn)
            angle = 0; // TODO
        else if (state == ArmState.FrontBallCargo)
            angle = 0; // TODO
        else if (state == ArmState.FrontBallRocket)
            angle = 0; // TODO
        else if (state == ArmState.BackBallHumanIn)
            angle = 0; // TODO
        else if (state == ArmState.BackBallCargo)
            angle = 0; // TODO
        else if (state == ArmState.BackBallRocket)
            angle = 0; // TODO
        else if (state == ArmState.FrontHatchInOut)
            angle = 0; // TODO
        else if (state == ArmState.BackHatchInOut)
            angle = 0; // TODO
        else {
            System.out.println("ARM THIS IS NOT HOW TO USE CUSTOM SETPOINT, hopefully 0 did not break anything");
            angle = 0; // hopefully that doesn't break anything
        }
        return angle;
    }

    // --------------------- JAW -------------------------
    public static final double kJawGearRatioEncoder2Jaw = 1;// TODO
    public static final double kJawGearRatioJaw2Encoder = 1 / kJawGearRatioEncoder2Jaw;

    public static final double kJawPIDTolerance = 5;// degs

    public static double kJawkP = 0.0001;// TODO
    public static double kJawkI = 0;// TODO
    public static double kJawkD = 0;// TODO
    public static double kJawkF = 0;// TODO

    public static double calcJawAngle(JawState state) {
        double angle;
        if (state == JawState.Back)
            angle = 0;// TODO
        else if (state == JawState.Front)
            angle = 0;// TODO
        else if (state == JawState.Ball)
            angle = 0;// TODO
        else {
            System.out.println("JAW THIS IS NOT HOW TO USE CUSTOM SETPOINT, hopefully 0 did not break anything");
            angle = 0;
        }
        return angle;
    }
    // --------------------- LED -------------------------

    public static double calcLEDSpd(LEDState state) {
        double spd;
        if (state == LEDState.Green)
            spd = 0;
        else if (state == LEDState.White)
            spd = 0;
        else if (state == LEDState.Yellow)
            spd = 0;
        else {
            System.out.println("LED THIS IS NOT HOW TO USE CUSTOM SETPOINT, hopefully 0 did not break anything");
            spd = 0;
        }
        return spd;
    }

    // --------------------- BALL INTAKE -------------------------
    public static final int kBallIntakeNormalAmp = 10;// TODO
    public static final int kBallIntakeStallAmp = 3;// TODO

    public static final double kBallIntakeSpdSlow = 0.5;// TODO
    public static final double kBallIntakeSpd = 1;// TODO

    // --------------------- DRIVE -------------------------
    public static final double kDriveJoystickDeadband = 0.05;

    public static final double[] kDrivePowerGears = { 0.3333, 0.6666, 1 };
    public static final double[] kDriveTurnGears = { 0.3333, 0.6666, 1 };

    public static final double maxAccelMSS = 100;

}
