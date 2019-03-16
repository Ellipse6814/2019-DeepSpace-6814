package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Util.ArmState;
import frc.robot.Util.JawState;
import frc.robot.Util.LEDState;

public class Const {
    // ======================== UNIT CONVERSIONS: ==========================
    /** To use: multiply variable with the constant below */
    public static final double kDeg2Talon4096Unit = 1 / 360.0 * 4096.0;
    public static final double kTalon4096Unit2Deg = 1 / kDeg2Talon4096Unit;
    public static final double kArmDeg2Talon4096Unit = 1 / 360.0 * 512.0;
    public static final double kArmTalon4096Unit2Deg = 1 / kArmDeg2Talon4096Unit;

    // ============================= GENERAL: ==============================

    public static final int kTalonCommTimeout = 10; // ms

    // ============================= WIRING: ===============================

    // Pneumatic
    public static final int kIntakeSolenoidPort1 = 0;
    public static final int kIntakeSolenoidPort2 = 1;

    public static final Value kHatchIntakeOpenPos = Value.kForward;
    public static final Value kHatchIntakeClosePos = Value.kReverse;

    // Hall Effect sensors
    public static final int kJawHallEffectSensorPort = 1;
    public static final int kArmHallEffectFrontSensorPort = 0;
    public static final int kArmHallEffectBackSensorPort = 2;// NOT USING!

    // motors (inverts)
    public static final int kJawAngleMotorPort = 2;
    public static final boolean kJawAngleMotorInverted = false;

    public static final int kIntakeRollerMotorPort = 4;
    public static final boolean kIntakeRollerMotorInverted = false;

    public static final int kArmMotorPort = 5;
    public static final boolean kArmMotorInverted = false; // front 0123; back 456; front lowest pt: 0
    public static final int kArmMotorSlavePort = 3;

    public static final int kDriveLeftMasterMotorPort = 3;
    public static final boolean kDriveLeftMasterMotorInverted = true;
    public static final int kDriveRightMasterMotorPort = 1;
    public static final boolean kDriveRightMasterMotorInverted = false;
    public static final int kDriveLeftSlaveMotorPort = 1;
    public static final int kDriveRightSlaveMotorPort = 2;

    public static final int kLEDPort = 4;

    // Encoder inverts
    public static final boolean kArmEncoderInverted = true;
    public static final boolean kJawEncoderInverted = true;
    public static final boolean kDriveLeftEncoderInverted = false;
    public static final boolean kDriveRightEncoderInverted = false;

    // Current Limits

    public static final int kDriveMotorMaxAmp = 50; // 50A
    public static final int kArmMotorMaxAmp = 50;
    public static final int kJawMotorMaxAmp = 30;

    // ======================== ENCODER PRESET POSITIONS: ==========================

    // ------------------- ARM --------------------------
    public static final double kArmGearRatioEncoder2Arm = 26.0 / 42.0 * 18.0 / 60.0 * 18.0 / 84.0; // to use, multiple
                                                                                                   // var
    // with this
    // const
    public static final double kArmGearRatioArm2Encoder = 1.0 / kArmGearRatioEncoder2Arm;

    public static final double kArmPIDTolerance = 5;// degs

    public static final int kArmLowerSoftLimit = 0;
    public static final int kArmUpperSoftLimit = 175;

    public static double kArmkP = 0.6;
    public static double kArmkI = 0;
    public static double kArmkD = 0.006;
    public static double kArmkF = 0;

    public static double calcArmAngle(ArmState state) {
        double angle;
        if (state == ArmState.FrontBallFloorIn)
            angle = 0;
        else if (state == ArmState.FrontBallHumanIn)
            angle = 75;
        else if (state == ArmState.FrontBallCargo)
            angle = 65;
        else if (state == ArmState.FrontBallRocket)
            angle = 65;
        else if (state == ArmState.BackBallHumanIn)
            angle = 145;
        else if (state == ArmState.BackBallCargo)
            angle = 150;
        else if (state == ArmState.BackBallRocket)
            angle = 150;
        else if (state == ArmState.FrontHatchInOut)
            angle = 0;
        else if (state == ArmState.BackHatchInOut)
            angle = 153;
        else if (state == ArmState.Middle)
            angle = 90;
        else {
            System.out.println("ARM FATAL ERROR: THIS IS NOT HOW TO USE CUSTOM SETPOINT");
            angle = 0;
        }
        return angle;
    }

    // --------------------- JAW -------------------------

    public static final double kJawGearRatioEncoder2Jaw = 18.0 / 32.0;
    public static final double kJawGearRatioJaw2Encoder = 1 / kJawGearRatioEncoder2Jaw;

    public static final double kJawPIDTolerance = 5;// degs

    public static final int kJawLowerSoftLimit = 0;
    public static final int kJawUpperSoftLimit = 110;

    public static double kJawkP = 0.3;
    public static double kJawkI = 0;
    public static double kJawkD = 0.1;// TODO:
    public static double kJawkF = 0;

    public static double calcJawAngle(JawState state) {
        double angle;
        if (state == JawState.Back)
            angle = 22;
        else if (state == JawState.Front)
            angle = 0;
        else if (state == JawState.Ball)
            angle = 0;// 0;
        else if (state == JawState.BallOut)
            angle = 105;
        else if (state == JawState.BallHuman)
            angle = 105;
        else {
            System.out.println("JAW FATAL ERROR: THIS IS NOT HOW TO USE CUSTOM SETPOINT");
            angle = 0;
        }
        return angle;
    }

    // --------------------- BALL INTAKE -------------------------
    public static final int kBallIntakeNormalAmp = 40;
    public static final int kBallIntakeStallAmp = 10;

    public static final int kBallIntakeConsiderBallInAmp = 40;
    public static final int kBallIntakeConsiderBallInCount = 10;

    public static final double kBallIntakeSpdSlow = 0.5;
    public static final double kBallIntakeHoldSpd = 0.1;
    public static final double kBallIntakeSpd = 0.7;// TODO

    // --------------------- DRIVE -------------------------
    public static final double kDriveJoystickDeadband = 0.05;

    public static final double[] kDrivePowerGears = { 0.3333, 0.6666, 1 };
    public static final double[] kDriveTurnGears = { 0.17, 0.25, 0.3 };

    public static final double maxAccelMSS = 100;

}
