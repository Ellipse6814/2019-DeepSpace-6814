package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {

    private double timeout; // in seconds

    public Wait(double timeout) {
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
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
