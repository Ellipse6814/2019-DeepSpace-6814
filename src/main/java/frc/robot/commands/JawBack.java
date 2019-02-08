package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Enums.JawState;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Jaw;

@Deprecated
public class JawBack extends Command {

    private Jaw jaw = Robot.jaw;

    public JawBack() {
        requires(jaw);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        jaw.state = JawState.Back;
        jaw.setAngle(Const.kJawSetpointDegBack);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
