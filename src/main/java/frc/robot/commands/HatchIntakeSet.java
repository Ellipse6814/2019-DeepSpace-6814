package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Enums.HatchState;
import frc.robot.subsystems.HatchIntake;

public class HatchIntakeSet extends Command {

    private HatchIntake hatchIntake = Robot.hatchIntake;

    private HatchState state;

    public HatchIntakeSet(HatchState state) {
        requires(hatchIntake);
        this.state = state;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (hatchIntake.state == state)
            return;

        if (state == HatchState.Open) {
            hatchIntake.openHatchIntake();
            // hatchIntake.state//TODO: ???
        } else {
            hatchIntake.closeHatchIntake();
        }
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