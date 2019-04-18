package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.subsystems.Arm;

public class ArmSetAngle extends Command {

    private Arm arm = Robot.arm;
    private double angle;
    private ArmState state;

    public ArmSetAngle(ArmState state) {
        this(state, 0);

        if (state == ArmState.Custom) {
            System.out.println("Unspecified custom arm command.");
        }
    }

    public ArmSetAngle(ArmState state, double angle) {
        requires(arm);
        this.angle = angle;
        this.state = state;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("CMD: set ARM state: " + state);
        if (state == ArmState.Custom) {
            arm.setAngle(angle);
        } else {
            arm.set(state);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false; // Don't finish: to hold up the subsystem's attention so other commands don't
                      // rush on and take over
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
