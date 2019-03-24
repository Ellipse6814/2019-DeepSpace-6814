package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Util.MotorDirection;
import frc.robot.auto.*;
import frc.robot.log.Logger;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Jaw;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.LifeCam;
import frc.robot.subsystems.ModeSystem;
import frc.robot.subsystems.NetworkTables;
import frc.robot.subsystems.Pneumatic;

public class Robot extends TimedRobot {
    public static NetworkTables networkTables;
    public static Pneumatic pneumatic;
    public static Drive drive;
    public static BallIntake ballIntake;
    public static HatchIntake hatchIntake;
    public static Arm arm;
    public static Jaw jaw;
    public static LifeCam msLifeCam;
    public static Logger logger;
    public static Telemetry telemetry;
    public static ModeSystem modeSystem;
    public static OI oi;
    public static LED led;

    Command autoCommand;
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    private void initSubsystems() {
        // printRAM();
        networkTables = NetworkTables.getInstance();
        // printRAM();
        pneumatic = Pneumatic.getInstance();
        // printRAM();
        drive = Drive.getInstance();
        // printRAM();
        ballIntake = BallIntake.getInstance();
        // printRAM();
        hatchIntake = HatchIntake.getInstance();
        // printRAM();
        arm = Arm.getInstance();
        // printRAM();
        jaw = Jaw.getInstance();
        // printRAM();
        msLifeCam = LifeCam.getInstance();
        // printRAM();
        logger = Logger.getInstance();
        // printRAM();
        modeSystem = ModeSystem.getInstance();
        // printRAM();
        oi = OI.getInstance();
        // printRAM();
        telemetry = Telemetry.getInstance();
        // printRAM();
        led = LED.getInstance(); // this needs to be inited last
        // printRAM();
    }

    @Override
    public void robotInit() {
        initSubsystems();
        turnOffMotors();
        initAutoChooser();
    }

    private void initAutoChooser() {
        autoChooser.setDefaultOption("Do Nothing", new AutoDoNothing());
        autoChooser.addOption("Grab Hatch", new AutoGrabHatch());
        // autoChooser.addOption("Left Cargo Cargo", new AutoLeftCargoCargo());
        // autoChooser.addOption("Left Rocket Cargo", new AutoLeftRocketCargo());
        autoChooser.addOption("Right Cargo Cargo", new AutoRightCargoCargo());
        // autoChooser.addOption("Right Rocket Cargo", new AutoRightRocketCargo());
        // autoChooser.addOption("Middle Left Cargo Cargo", new
        // AutoMiddleLeftCargoCargo());
        // autoChooser.addOption("Middle Right Cargo Cargo", new
        // AutoMiddleRightCargoCargo());
        // autoChooser.addOption("Right Rocket Cargo", new AutoRightRocketCargo());
        SmartDashboard.putData("Auto Mode Chooser", autoChooser);
    }

    @Override
    public void robotPeriodic() {
        telemetry.update();
        led.update();
        oi.update();
    }

    @Override
    public void disabledInit() {
        turnOffMotors();
    }

    @Override
    public void disabledPeriodic() {
        tryToResetSensors();
        // Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        turnOnMotors();
        autoCommand = autoChooser.getSelected();

        if (autoCommand != null) {
            autoCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        turnOnMotors();
        if (autoCommand != null) {
            autoCommand.cancel();
        }

    }

    private int count = 0;

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {
        turnOnMotors();
        pneumatic.startCompressor();
    }

    // Joystick joy1 = oi.getDoubleJoystick1();

    @Override
    public void testPeriodic() {

        // // // drive
        // // drive.drive(joy1.getRawAxis(1), joy1.getRawAxis(5));

        // // // arm
        // double armSpd = joy1.getRawAxis(3) - joy1.getRawAxis(2);
        // // armSpd *= 0.4;
        // armSpd *= 1500;
        // SmartDashboard.putNumber("Arm Spd", armSpd);
        // MotorDirection md = MotorDirection.Forward;
        // if (armSpd < 0)
        // md = MotorDirection.Backward;
        // SmartDashboard.putBoolean("ArmDirection", (md == MotorDirection.Forward) ?
        // true : false);
        // SmartDashboard.putNumber("ArmTalonOuput",
        // arm.armMotor.getMotorOutputPercent());
        // // arm.armMotor.set(ControlMode.PercentOutput, armSpd);
        // if (joy1.getRawButton(1))
        // hatchIntake.openHatchIntake();
        // else
        // hatchIntake.closeHatchIntake();

        // // if (joy1.getRawButton(2))
        // // arm.setAngle(5);
        // // else if (joy1.getRawButton(3))
        // // arm.setAngle(80);
        // // else if (joy1.getRawButton(4))
        // // arm.setAngle(145);
        // // // else
        // // arm.setOpenLoop(Math.abs(armSpd), md);
        // // jaw.setOpenLoop(Math.abs(armSpd), md);
        // if (joy1.getRawButton(6))
        // arm.resetEncoder();
        // ballIntake.rollerMotor.set(ControlMode.PercentOutput, -0.5);
        // // jaw.jawAngleMotor.set(ControlMode.PercentOutput, armSpd);
        // // jaw.jawAngleMotor.set(ControlMode.Position, armSpd);
    }

    public void tryToResetSensors() {
        arm.resetPeriodic();
        jaw.resetPeriodic();
    }

    public void turnOffMotors() {
        drive.disable();
        jaw.disable();
        arm.disable();
    }

    public void turnOnMotors() {
        drive.enable();
        jaw.enable();
        arm.enable();
    }

    public static void printRAM() {
        final double mb = 1024.0 * 1024.0;
        Runtime runtime = Runtime.getRuntime();
        double ramFree = runtime.freeMemory() / mb;
        double totalRam = runtime.totalMemory() / mb;
        double usedRam = totalRam - ramFree;
        System.out.println("Total: " + totalRam + ";  Used: " + usedRam + ";  free: " + ramFree);
    }
}
