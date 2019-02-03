/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static OI instance;

    public static OI getInstance() {
        if (instance == null)
            instance = new OI();
        return instance;
    }

    private Joystick doubleJoystick1 = new Joystick(0);
    private Joystick doubleJoystick2 = new Joystick(1);
    private Joystick singleJoystick1 = new Joystick(2);
    private Joystick singleJoystick2 = new Joystick(3);

    // private JoystickButton hatchOpenBtn = new JoystickButton(joystick, buttonNumber);

    private OI() {

    }

    public Joystick getDoubleJoystick1() {
        return doubleJoystick1;
    }

    public Joystick getDoubleJoystick2() {
        return doubleJoystick2;
    }

    public Joystick getSingleJoystick1() {
        return singleJoystick1;
    }

    public Joystick getSingleJoystick2() {
        return singleJoystick2;
    }


    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
