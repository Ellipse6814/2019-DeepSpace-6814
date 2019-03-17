package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

/**
 * An example command. You can replace me with your own command.
 */
public class DriveSetGear extends Command {

    private Drive drive = Robot.drive;

    private boolean gearUp;

    public DriveSetGear(boolean gearUp) {
        this.gearUp = gearUp;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("CMD: setgear: " + gearUp);
        if (gearUp)
            drive.gearUp();
        else
            drive.gearDown();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
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
