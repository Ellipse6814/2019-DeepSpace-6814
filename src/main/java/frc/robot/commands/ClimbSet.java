package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.BallState;
import frc.robot.Util.MotorDirection;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Climb;

public class ClimbSet extends Command {

    private Climb climb = Robot.climb;

    private boolean front;
    private boolean back;

    public ClimbSet(boolean front, boolean back) {
        // requires(climb);
        this.front = front;
        this.back = back;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        climb.setFront(front);
        climb.setBack(back);
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
        climb.setBack(!back);
        climb.setFront(!front);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
