package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

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

    // private JoystickButton hatchOpenBtn = new JoystickButton(joystick,
    // buttonNumber);

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
