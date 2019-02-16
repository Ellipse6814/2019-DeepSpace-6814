package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.JawState;
import frc.robot.subsystems.Jaw;

public class JawSetAngle extends Command {

    private Jaw jaw = Robot.jaw;
    private double angle;
    private JawState state;

    public JawSetAngle(JawState state) {
        this(state, 0);

        if (state == JawState.Custom) {
            System.out.println("Unspecified custom jaw command.");
        }
    }

    public JawSetAngle(JawState state, double angle) {
        requires(jaw);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (state == JawState.Custom) {
            jaw.setAngle(angle);
        } else {
            jaw.set(state);
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
