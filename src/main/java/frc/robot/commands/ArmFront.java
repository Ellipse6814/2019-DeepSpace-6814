package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Enums.ArmState;
import frc.robot.Enums.JawState;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Jaw;

@Deprecated
public class ArmFront extends Command {

    private Arm arm = Robot.arm;

    public ArmFront() {
        requires(arm);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        // arm.state = ArmState.Front;
        // arm.setAngle(Const.kJawSetpointDegIdle);
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
