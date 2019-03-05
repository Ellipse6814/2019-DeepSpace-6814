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

public class OI {

    private static OI instance;

    public static OI getInstance() {
        if (instance == null)
            instance = new OI();
        return instance;
    }

    private Joystick doubleJoystick1 = new Joystick(0);
    private Joystick controlBoard = new Joystick(1);
    private Joystick singleJoystick1 = new Joystick(3);

    private boolean networkTablesExecButtonDown = false;

    private OI() {
        initGearButtons();
        initControlBoard();
        initVirtualControlBoard();
        initJoystickControlBoard();
    }

    private void initGearButtons() {
        JoystickButton gearUpBtn = new JoystickButton(doubleJoystick1, 6);
        JoystickButton gearDownBtn = new JoystickButton(doubleJoystick1, 4);

        gearUpBtn.whenPressed(new DriveSetGear(true));
        gearDownBtn.whenPressed(new DriveSetGear(false));
    }

    private void initJoystickControlBoard() {
        JoystickButton frontBallFloorIn = new JoystickButton(singleJoystick1, 0);
        JoystickButton frontBallOut = new JoystickButton(singleJoystick1, 0);
        JoystickButton frontHatchIn = new JoystickButton(singleJoystick1, 0);
        JoystickButton frontHatchOut = new JoystickButton(singleJoystick1, 0);
        JoystickButton backBallOut = new JoystickButton(singleJoystick1, 0);
        JoystickButton backHatchOut = new JoystickButton(singleJoystick1, 0);
        JoystickButton backHatchIn = new JoystickButton(singleJoystick1, 0);
        JoystickButton armReset = new JoystickButton(singleJoystick1, 0);
        JoystickButton jawReset = new JoystickButton(singleJoystick1, 0);
        JoystickButton disableRobot = new JoystickButton(singleJoystick1, 0);

        frontBallFloorIn.whenPressed(new FrontBallFloorIn());
        frontBallOut.whenPressed(new FrontBallCargo());
        frontHatchIn.whenPressed(new FrontHatchIn());
        frontHatchOut.whenPressed(new FrontHatchOut());
        backBallOut.whenPressed(new BackBallCargo());
        backHatchOut.whenPressed(new BackHatchOut());
        backHatchIn.whenPressed(new BackHatchIn());
        armReset.whenPressed(new ArmReset());
        jawReset.whenPressed(new JawReset());
    }

    private void initControlBoard() {
        JoystickButton frontBallFloorIn = new JoystickButton(controlBoard, 0);
        JoystickButton frontBallOut = new JoystickButton(controlBoard, 0);
        JoystickButton frontHatchIn = new JoystickButton(controlBoard, 0);
        JoystickButton frontHatchOut = new JoystickButton(controlBoard, 0);
        JoystickButton backBallOut = new JoystickButton(controlBoard, 0);
        JoystickButton backHatchOut = new JoystickButton(controlBoard, 0);
        JoystickButton backHatchIn = new JoystickButton(controlBoard, 0);
        JoystickButton armReset = new JoystickButton(controlBoard, 0);
        JoystickButton jawReset = new JoystickButton(controlBoard, 0);
        JoystickButton disableRobot = new JoystickButton(controlBoard, 0);

        frontBallFloorIn.whenPressed(new FrontBallFloorIn());
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
        Robot.networkTables.listen("Table1", "mode", new Listener() {
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
        Robot.networkTables.listen("Table1", "execBtn", new Listener() {
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
        return doubleJoystick1.getRawButton(1) || networkTablesExecButtonDown;
    }

    public double getDrivePower() {
        return doubleJoystick1.getRawAxis(1);
    }

    public double getDriveTurn() {
        return doubleJoystick1.getRawAxis(4);
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
