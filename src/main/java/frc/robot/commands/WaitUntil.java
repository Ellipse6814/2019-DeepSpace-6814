package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.Evaluate;

public class WaitUntil extends Command {

    private Evaluate condition;
    private boolean isFinished = false;

    public WaitUntil(Evaluate evaluate) {
        this.condition = evaluate;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (condition.evaluate())
            isFinished = true;
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
