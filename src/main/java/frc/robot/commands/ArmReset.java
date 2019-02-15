package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.MotorDirection;
import frc.robot.subsystems.Arm;

public class ArmReset extends Command {

    private Arm arm = Robot.arm;

    private boolean isFinished = false;

    public ArmReset() {
        requires(arm);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        arm.state = ArmState.Reset;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        arm.setOpenLoop(0.3, MotorDirection.Forward);
        if (arm.getFrontHallEffect()) {
            arm.setOpenLoop(0, MotorDirection.Forward);
            arm.resetEncoder();
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
