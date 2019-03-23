package frc.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.HatchState;
import frc.robot.commands.HatchIntakeSet;
import frc.robot.commands.SetRobot;
import frc.robot.subsystems.HatchIntake;

public class AutoGrabHatch extends Command {

    private HatchIntake hatchIntake = Robot.hatchIntake;
    private Command cmd;

    public AutoGrabHatch() {
        requires(hatchIntake);
    }

    @Override
    protected void initialize() {
        cmd = new HatchIntakeSet(HatchState.Grab);
        cmd.start();
    }

    @Override
    protected void execute() {
        // executes nothing
    }

    @Override
    protected boolean isFinished() {
        // finishes nothing
        return false;
    }

    @Override
    protected void end() {
        // ends nothing
    }

    @Override
    protected void interrupted() {
        // interrupts nothing
    }
}
