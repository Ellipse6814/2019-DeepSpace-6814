package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Enums.MotorDirection;
import frc.robot.subsystems.BallIntake;

public class BallIntakeSet extends Command {

    private BallIntake ballIntake = Robot.ballIntake;

    private int amp;

    public BallIntakeSet(int amp) {
        requires(ballIntake);
        this.amp = amp;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        ballIntake.setMotor(MotorDirection.Forward, amp);
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
