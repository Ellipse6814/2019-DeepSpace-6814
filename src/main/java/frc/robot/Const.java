/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Const {
    // Talon Consts
    public static final double getTalon4096Units(double angle) {
        return angle / 360 * 4096;
    }

    public static final int kTalonCommTimeout = 10; // ms

    // Arm Setpoints
    public static final double kArmSetpointDegFrontBallOut = 0;
    public static final double kArmSetpointDegFrontBallIn = 0;
    public static final double kArmSetpointDegFrontHatchInOut = 0;
    public static final double kArmSetpointDegBackHatchInOut = 0;
    public static final double kArmSetpointDegBackBallOut = 0;
    public static final double kArmSetpointDegMiddle = 0;
    // Jaw Setpoints
    public static final double kJawSetpointDegFront = 0;
    public static final double kJawSetpointDegBack = 0;
    public static final double kJawSetpointDegIdle = 0;

    // ball intake
    public static final int kBallIntakeInAmp = 10;
    public static final int kBallIntakeOutAmp = 10;
    public static final int kBallIntakeHoldAmp = 3;

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

}
