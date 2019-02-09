package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Enums.JawState;
import frc.robot.Enums.MotorDirection;
import frc.robot.subsystems.Jaw;

public class JawReset extends Command {

    private Jaw jaw = Robot.jaw;

    private boolean isFinished = false;

    public JawReset() {
        requires(jaw);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        jaw.state = JawState.Reset;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        jaw.setOpenLoop(0.3, MotorDirection.Forward);
        if (jaw.getHallEffect()) {
            jaw.setOpenLoop(0, MotorDirection.Forward);
            jaw.resetEncoder();
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
