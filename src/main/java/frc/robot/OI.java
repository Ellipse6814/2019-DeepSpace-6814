package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        initSmartDashboardControlButtons();
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
        return singleJoystick1.getRawButton(1);
    }

    private void initSmartDashboardControlButtons() {
        SmartDashboard.putData("Front Ball Floor In", new FrontBallFloorIn());
        SmartDashboard.putData("Front Ball Human In", new FrontBallHumanIn());
        SmartDashboard.putData("Front Ball Cargo Out", new FrontBallCargo());
        SmartDashboard.putData("Front Ball Rocket Out", new FrontBallRocket());
        SmartDashboard.putData("Front Hatch In", new FrontHatchIn());
        SmartDashboard.putData("Front Hatch Out", new FrontHatchOut());

        SmartDashboard.putData("Back Ball Human In", new BackBallHumanIn());
        SmartDashboard.putData("Back Ball Cargo Out", new BackBallCargo());
        SmartDashboard.putData("Back Ball Rocket Out", new BackBallRocket());
        SmartDashboard.putData("Back Hatch In", new BackHatchIn());
        SmartDashboard.putData("Back Hatch Out", new BackHatchOut());

        SmartDashboard.putData("Middle Idle", new MiddleIdle());

    }

    private void initPIDTuner() {
        SmartDashboard.putNumber("Arm P", Const.kArmkP);
        SmartDashboard.putNumber("Arm I", Const.kArmkI);
        SmartDashboard.putNumber("Arm D", Const.kArmkD);
        SmartDashboard.putNumber("Arm F", Const.kArmkF);
        SmartDashboard.putNumber("Jaw P", Const.kJawkP);
        SmartDashboard.putNumber("Jaw I", Const.kJawkI);
        SmartDashboard.putNumber("Jaw D", Const.kJawkD);
        SmartDashboard.putNumber("Jaw F", Const.kJawkF);
    }
}
