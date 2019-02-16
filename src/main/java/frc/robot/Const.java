package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Util.ArmState;
import frc.robot.Util.JawState;
import frc.robot.Util.LEDState;

public class Const {
    // ======================== UNIT CONVERSIONS: ==========================
    public static final double deg2Talon4096Unit(double angle) {
        return angle / 360.0 * 4096.0;
    }

    public static final double talon4096Unit2Deg(double angle) {
        return angle * 360.0 / 4096.0;
    }

    // ============================= GENERAL: ==============================

    public static final int kTalonCommTimeout = 10; // ms

    // ============================= WIRING: ===============================

    // pneumatic
    public static final int kIntakeSolenoidPort1 = 0;
    public static final int kIntakeSolenoidPort2 = 1;

    public static final Value kHatchIntakeOpenPos = Value.kForward;
    public static final Value kHatchIntakeClosePos = Value.kReverse;

    // hall effect sensors
    public static final int kJawHallEffectSensorPort = -25535; // TODO: this will throw an error
    public static final int kArmHallEffectFrontSensorPort = -25535; // TODO: this will throw an error
    public static final int kArmHallEffectBackSensorPort = -25535; // TODO: this will throw an error

    // motors
    public static final int kJawAngleMotorPort = -25535; // TODO: this will throw an error
    public static final int kIntakeRollerMotorPort = -25535; // TODO: this will throw an error
    public static final int kArmMotorPort = -25535; // TODO: this will throw an error
    public static final int kArmMotorSlavePort = -25535; // TODO: this will throw an error

    // Drive

    public static final int kDriveLeftMasterMotorPort = 0;
    public static final int kDriveRightMasterMotorPort = 0;
    public static final int kDriveLeftSlaveMotorPort = 0;
    public static final int kDriveRightSlaveMotorPort = 0;

    public static final int kDriveMotorMaxAmp = 50; // 50A
    public static final double kDriveJoystickDeadband = 0.05;

    public static final double[] kDrivePowerGears = { 0.3333, 0.6666, 1 };
    public static final double[] kDriveTurnGears = { 0.3333, 0.6666, 1 };

    public static final double maxAccelMSS = 100;

    // LEDs:

    public static final int kLEDPort = 0;

    // ======================== ENCODER PRESET POSITIONS: ==========================

    // ------------------- ARM -------------------------- //TODO:

    public static final double kArmPIDTolerance = 5;// degs

    public static double calcArmAngle(ArmState state) {
        double angle;
        if (state == ArmState.FrontBallFloorIn)
            angle = 0;
        else if (state == ArmState.FrontBallHumanIn)
            angle = 0;
        else if (state == ArmState.FrontBallCargo)
            angle = 0;
        else if (state == ArmState.FrontBallRocket)
            angle = 0;
        else if (state == ArmState.BackBallHumanIn)
            angle = 0;
        else if (state == ArmState.BackBallCargo)
            angle = 0;
        else if (state == ArmState.BackBallRocket)
            angle = 0;
        else if (state == ArmState.FrontHatchInOut)
            angle = 0;
        else if (state == ArmState.BackHatchInOut)
            angle = 0;
        else {
            System.out.println("ARM THIS IS NOT HOW TO USE CUSTOM SETPOINT, hopefully 0 did not break anything");
            angle = 0; // hopefully that doesn't break anything
        }
        return angle;
    }
    // --------------------- JAW -------------------------

    public static double calcJawAngle(JawState state) {
        double angle;
        if (state == JawState.Back)
            angle = 0;
        else if (state == JawState.Front)
            angle = 0;
        else if (state == JawState.Ball)
            angle = 0;
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

    public static final int kBallIntakeNormalAmp = 10;
    public static final int kBallIntakeStallAmp = 3;

    public static final double kBallIntakeSpdSlow = 0.5;
    public static final double kBallIntakeSpd = 1;
}
