package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Enums.BallState;
import frc.robot.Enums.MotorDirection;
import frc.robot.subsystems.BallIntake;

public class BallIntakeSet extends Command {

    private BallIntake ballIntake = Robot.ballIntake;

    private BallState state;

    private int amp = 0;
    private double speed = 0;
    private boolean ifCustomUseAmp = false;
    private boolean intake = false;

    public BallIntakeSet(BallState state) {
        requires(ballIntake);
        if (state == BallState.Custom) {
            System.out.println("Unspecified custom ballintake command.");
        }
        this.state = state;
    }

    public BallIntakeSet(boolean intake, int amp) {
        requires(ballIntake);
        this.amp = amp;
        this.state = BallState.Custom;
        this.ifCustomUseAmp = true;
        this.intake = intake;
    }

    public BallIntakeSet(boolean intake, double speed) {
        requires(ballIntake);
        this.speed = speed;
        this.state = BallState.Custom;
        this.ifCustomUseAmp = false;
        this.intake = intake;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (state == BallState.In) {
            ballIntake.setCurrentPID(MotorDirection.Backward, Const.kBallIntakeInAmp);
        } else if (state == BallState.Out) {
            ballIntake.setMotor(MotorDirection.Forward, Const.kBallIntakeOutSpd);
        } else if (state == BallState.OutSlow) {
            ballIntake.setMotor(MotorDirection.Forward, Const.kBallIntakeOutSpdSlow);
        } else if (state == BallState.Hold) {
            if (Timer.getFPGATimestamp() % 1000 < 500)
                ballIntake.setCurrentPID(MotorDirection.Backward, Const.kBallIntakeInAmp);
        } else if (state == BallState.Custom) {
            MotorDirection md = intake ? MotorDirection.Backward : MotorDirection.Forward;
            if (ifCustomUseAmp) {
                ballIntake.setCurrentPID(md, amp);
            } else {
                ballIntake.setMotor(md, speed);
            }
        } else { // if (state == BallState.Stop) {
            ballIntake.setMotor(MotorDirection.Forward, 0);
        }
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
