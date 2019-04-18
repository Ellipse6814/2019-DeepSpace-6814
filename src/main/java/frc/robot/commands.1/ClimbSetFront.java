package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Climb;

public class ClimbSetFront extends Command {

    private Climb climb = Robot.climb;

    private boolean front;

    public ClimbSetFront(boolean front) {
        // requires(climb);
        this.front = front;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        climb.setFront(front);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        climb.setFront(!front);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
