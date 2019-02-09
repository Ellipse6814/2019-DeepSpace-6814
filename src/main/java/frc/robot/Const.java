package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Const {
    // Talon Consts
    public static final double deg2Talon4096Unit(double angle) {
        return angle / 360.0 * 4096.0;
    }

    public static final double talon4096Unit2Deg(double angle) {
        return angle * 360.0 / 4096.0;
    }

    public static final int kTalonCommTimeout = 10; // ms

    // Arm Setpoints
    public static final double kArmSetpointDegFrontBallOut = 0;
    public static final double kArmSetpointDegFrontBallIn = 0;
    public static final double kArmSetpointDegFrontHatchInOut = 0;
    public static final double kArmSetpointDegBackHatchInOut = 0;
    public static final double kArmSetpointDegBackBallOut = 0;
    public static final double kArmSetpointDegMiddle = 0;

    public static final double kArmPIDTolerance = 5;// degs
    // Jaw Setpoints
    public static final double kJawSetpointDegFront = 0;
    public static final double kJawSetpointDegBack = 0;
    public static final double kJawSetpointDegIdle = 0;

    // ball intake
    public static final int kBallIntakeNormalAmp = 10;
    public static final int kBallIntakeStallAmp = 3;

    public static final double kBallIntakeSpdSlow = 0.5;
    public static final double kBallIntakeSpd = 1;

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

    public static final int kDriveMotorMaxAmp = 50; // 50A

}
