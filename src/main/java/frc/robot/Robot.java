package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.auto.AutoDoNothing;
import frc.robot.log.Logger;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Jaw;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Pneumatic;

public class Robot extends TimedRobot {
    public static OI oi = OI.getInstance();
    public static Pneumatic pneumatic = Pneumatic.getInstance();
    public static Drive drive = Drive.getInstance();
    public static BallIntake ballIntake = BallIntake.getInstance();
    public static HatchIntake hatchIntake = HatchIntake.getInstance();
    public static Arm arm = Arm.getInstance();
    public static Jaw jaw = Jaw.getInstance();
    public static LED led = LED.getInstance();
    public static Logger logger = Logger.getInstance();

    Command autoCommand;
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    @Override
    public void robotInit() {
        autoChooser.setDefaultOption("Do Nothing", new AutoDoNothing());
        // chooser.addOption("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto Mode Chooser", autoChooser);
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
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
        if (autoCommand != null) {
            autoCommand.cancel();
        }

    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}
