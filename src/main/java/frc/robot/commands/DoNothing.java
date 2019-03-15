package frc.robot.commands;

import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Util.DriveState;

public class DoNothing extends Command {

    public DoNothing() {
    }

    public DoNothing(Subsystem subsystem) {
        requires(subsystem);
    }

    public DoNothing(List<Subsystem> subsystems) {
        subsystems.forEach((subsystem) -> {
            requires(subsystem);
            if (subsystem == Robot.drive) {
                Robot.drive.state = DriveState.Disabled;
            }
        });
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

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
