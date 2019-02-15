package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

/**
 * An example command. You can replace me with your own command.
 */
public class Drive2Joy extends Command {

    private Joystick joy1 = Robot.oi.getDoubleJoystick1();
    private Drive drive = Robot.drive;

    public Drive2Joy() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("Driving with 2 joysticks!");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double power = joy1.getRawAxis(1);
        double turn = joy1.getRawAxis(4);
        drive.driveJoystick(power, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
