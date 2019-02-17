package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.path.PathFollower;

public class WaitUntilPathProgress extends Command {

    private PathFollower pathFollower;
    private double wantedProgress;
    private boolean isFinished = false;

    public WaitUntilPathProgress(Command pathFollower, double wantedProgress) {
        this.pathFollower = ((FollowPath) pathFollower).pathFollower; // THIS IS BY REFERENCE
        this.wantedProgress = wantedProgress;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (pathFollower.getProgress() >= wantedProgress) {
            System.out.println("Progress == wantedProgress == [" + wantedProgress + "]");
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isFinished;
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
