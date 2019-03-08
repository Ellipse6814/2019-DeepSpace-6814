package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.BallState;
import frc.robot.Util.LEDState;
import frc.robot.Util.MotorDirection;
import frc.robot.subsystems.BallIntake;

public class BallIntakeSet extends Command {

    private BallIntake ballIntake = Robot.ballIntake;

    private BallState state;

    private int amp = 0;
    private double speed = 0;
    private boolean intake = false;

    public BallIntakeSet(BallState state) {
        requires(ballIntake);
        if (state == BallState.Custom) {
            System.out.println("Unspecified custom ballintake command.");
        }
        this.state = state;
    }

    public BallIntakeSet(boolean intake, double speed, int amp) {
        requires(ballIntake);
        this.amp = amp;
        this.state = BallState.Custom;
        this.speed = speed;
        this.amp = amp;
        this.intake = intake;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (state == BallState.Custom) {
            MotorDirection md = intake ? MotorDirection.Forward : MotorDirection.Backward;
            ballIntake.setMotor(md, speed, amp);
            // Robot.led.set(LEDState.PrepOut);
        } else {
            ballIntake.set(state);
            // if (state == BallState.In)
            // Robot.led.set(LEDState.PrepOut);
            // else if (state == BallState.Out)
            // Robot.led.set(LEDState.DoneOut);
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
