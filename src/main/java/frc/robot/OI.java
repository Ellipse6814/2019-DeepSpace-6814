package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Util.Listener;
import frc.robot.commands.ArmReset;
import frc.robot.commands.DoNothing;
import frc.robot.commands.DriveSetGear;
import frc.robot.commands.JawReset;
import frc.robot.modes.*;
import frc.robot.subsystems.NetworkTables;

public class OI {

    private static OI instance;

    public static OI getInstance() {
        if (instance == null)
            instance = new OI();
        return instance;
    }

    private NetworkTables networkTables = NetworkTables.getInstance();

    private Joystick doubleJoystick1 = new Joystick(0);
    private Joystick controlBoard1 = new Joystick(1);
    private Joystick controlBoard2 = new Joystick(2);
    private Joystick singleJoystick1 = new Joystick(3);

    private boolean networkTablesExecButtonDown = false;

    JoystickButton gearUpBtn;
    JoystickButton gearDownBtn;
    JoystickButton frontBallFloorIn;
    JoystickButton frontBallFloorIn1;
    JoystickButton frontBallOut;
    JoystickButton frontHatchIn;
    JoystickButton frontHatchOut;
    JoystickButton backBallOut;
    JoystickButton backHatchOut;
    JoystickButton backHatchIn;
    JoystickButton armReset;
    JoystickButton jawReset;
    JoystickButton disableRobot;

    private OI() {
        initGearButtons();
        // initControlBoard();
        initVirtualControlBoard();
        // initJoystickControlBoard();
    }

    public void update() {
        Command cmd = new DoNothing();
        if (controlBoard1.getRawButton(1)) {
            cmd = new DoNothing();
            System.out.println("update button 1");
        } else if (controlBoard1.getRawButton(2)) {
            cmd = new DoNothing();
            System.out.println("update button 2");
        } else if (controlBoard1.getRawButton(3)) {
            cmd = new DoNothing();
            System.out.println("update button 3");
        } else if (controlBoard1.getRawButton(4)) {
            cmd = new DoNothing();
            System.out.println("update button 4");
        } else if (controlBoard1.getRawButton(5)) {
            cmd = new FrontHatchOut();
            System.out.println("update button 5");
        } else if (controlBoard1.getRawButton(6)) {
            cmd = new FrontHatchIn();
            System.out.println("update button 6");
        } else if (controlBoard1.getRawButton(7)) {
            cmd = new BackHatchIn();
            System.out.println("update button 7");
        } else if (controlBoard1.getRawButton(8)) {
            cmd = new BackHatchOut();
            System.out.println("update button 8");
        } else if (controlBoard1.getRawButton(9)) {
            cmd = new FrontBallCargo();
            System.out.println("update button 9");
        } else if (controlBoard1.getRawButton(10)) {
            cmd = new FrontBallFloorIn();
            System.out.println("update button 1");
        } else if (controlBoard1.getRawButton(11)) {
            cmd = new BackBallCargo();
            System.out.println("update button 1");
        } else if (controlBoard1.getRawButton(12)) {
            cmd = new DoNothing();
            System.out.println("update button 1");
        }
        cmd.start();
    }

    private void initGearButtons() {
        gearUpBtn = new JoystickButton(doubleJoystick1, 6);
        gearDownBtn = new JoystickButton(doubleJoystick1, 4);

        gearUpBtn.whenPressed(new DriveSetGear(true));
        gearDownBtn.whenPressed(new DriveSetGear(false));
    }

    // private void initJoystickControlBoard() {
    // JoystickButton frontBallFloorIn = new JoystickButton(singleJoystick1, 1);
    // JoystickButton frontBallOut = new JoystickButton(singleJoystick1, 1);
    // JoystickButton frontHatchIn = new JoystickButton(singleJoystick1, 1);
    // JoystickButton frontHatchOut = new JoystickButton(singleJoystick1, 1);
    // JoystickButton backBallOut = new JoystickButton(singleJoystick1, 1);
    // JoystickButton backHatchOut = new JoystickButton(singleJoystick1, 1);
    // JoystickButton backHatchIn = new JoystickButton(singleJoystick1, 1);
    // JoystickButton armReset = new JoystickButton(singleJoystick1, 1);
    // JoystickButton jawReset = new JoystickButton(singleJoystick1, 1);
    // JoystickButton disableRobot = new JoystickButton(singleJoystick1, 1);

    // frontBallFloorIn.whenPressed(new FrontBallFloorIn());
    // frontBallOut.whenPressed(new FrontBallCargo());
    // frontHatchIn.whenPressed(new FrontHatchIn());
    // frontHatchOut.whenPressed(new FrontHatchOut());
    // backBallOut.whenPressed(new BackBallCargo());
    // backHatchOut.whenPressed(new BackHatchOut());
    // backHatchIn.whenPressed(new BackHatchIn());
    // armReset.whenPressed(new ArmReset());
    // jawReset.whenPressed(new JawReset());
    // }

    private void initControlBoard() {
        frontBallFloorIn = new JoystickButton(controlBoard1, 10);
        frontBallFloorIn1 = new JoystickButton(doubleJoystick1, 1);
        frontBallOut = new JoystickButton(controlBoard1, 9);
        frontHatchIn = new JoystickButton(controlBoard1, 6);
        frontHatchOut = new JoystickButton(controlBoard1, 5);
        backBallOut = new JoystickButton(controlBoard1, 11);
        backHatchOut = new JoystickButton(controlBoard1, 8);
        backHatchIn = new JoystickButton(controlBoard1, 7);
        armReset = new JoystickButton(controlBoard2, 1);
        jawReset = new JoystickButton(controlBoard2, 2);
        disableRobot = new JoystickButton(controlBoard2, 3);

        frontBallFloorIn.whenPressed(new FrontBallFloorIn());
        frontBallFloorIn1.whenPressed(new FrontBallFloorIn());
        frontBallOut.whenPressed(new FrontBallCargo());
        frontHatchIn.whenPressed(new FrontHatchIn());
        frontHatchOut.whenPressed(new FrontHatchOut());
        backBallOut.whenPressed(new BackBallCargo());
        backHatchOut.whenPressed(new BackHatchOut());
        backHatchIn.whenPressed(new BackHatchIn());
        armReset.whenPressed(new ArmReset());
        jawReset.whenPressed(new JawReset());
    }

    private void initVirtualControlBoard() {
        networkTables.listen("Table1", "mode", new Listener() {
            @Override
            public void valueChanged(Object value) {
                String data = (String) value;
                Command cmd = new DoNothing();
                if (data == "frontBallFloorIn") {
                    cmd = new FrontBallFloorIn();
                } else if (data == "frontBallOut") {
                    cmd = new FrontBallCargo();
                } else if (data == "frontHatchIn") {
                    cmd = new FrontHatchIn();
                } else if (data == "frontHatchOut") {
                    cmd = new FrontHatchOut();
                } else if (data == "backBallOut") {
                    cmd = new BackBallCargo();
                } else if (data == "backHatchOut") {
                    cmd = new BackHatchOut();
                } else if (data == "backHatchIn") {
                    cmd = new BackHatchIn();
                } else if (data == "armReset") {
                    cmd = new ArmReset();
                } else if (data == "jawReset") {
                    cmd = new JawReset();
                }
                System.out.println("Received Controlboard Command: [" + data + "]");
                cmd.start();
            }
        });
        networkTables.listen("Table1", "execBtn", new Listener() {
            @Override
            public void valueChanged(Object value) {
                String data = (String) value;
                if (data == "down") {
                    networkTablesExecButtonDown = true;
                } else if (data == "up") {
                    networkTablesExecButtonDown = false;
                }
                System.out.println("Received Controlboard ExecBtn: [" + data + "]");
            }
        });
    }

    public boolean getExecButton() {
        return controlBoard2.getRawButton(4) || networkTablesExecButtonDown;
    }

    public double getDrivePower() {
        return doubleJoystick1.getRawAxis(1);
    }

    public double getDriveTurn() {
        return doubleJoystick1.getRawAxis(4);
    }

    public double getPOV() {
        return doubleJoystick1.getPOV();
    }

    @Deprecated
    public Joystick getDoubleJoystick1() {
        return doubleJoystick1;
    }

    @Deprecated
    public Joystick getSingleJoystick1() {
        return singleJoystick1;
    }

    // private Joystick doubleJoystick2 = new Joystick(2);
    // private Joystick singleJoystick2 = new Joystick(3);

    // private JoystickButton hatchOpenBtn = new JoystickButton(joystick,
    // buttonNumber);

    // @Deprecated
    // public Joystick getSingleJoystick2() {
    // return singleJoystick2;
    // }
    // @Deprecated
    // public Joystick getDoubleJoystick2() {
    // return doubleJoystick2;
    // }
}
