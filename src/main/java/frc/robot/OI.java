package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveSetGear;
import frc.robot.modes.*;

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
        initGearButtons();
    }

    private void initGearButtons() {
        JoystickButton gearUpBtn = new JoystickButton(doubleJoystick1, 6);
        JoystickButton gearDownBtn = new JoystickButton(doubleJoystick1, 4);

        gearUpBtn.whenPressed(new DriveSetGear(true));
        gearDownBtn.whenPressed(new DriveSetGear(false));
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

    public boolean getExecButton() {
        return doubleJoystick1.getRawButton(1);
    }

}
