/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Const {

    // intake

    // pneumatic
    public static final int kIntakeSolenoidPort1 = 0;
    public static final int kIntakeSolenoidPort2 = 1;

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
