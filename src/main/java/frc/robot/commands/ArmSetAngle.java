package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.subsystems.Arm;

public class ArmSetAngle extends Command {

    private Arm arm = Robot.arm;
    private double angle;
    private ArmState state;

    public ArmSetAngle(ArmState state) {
        this(state, 0);
    }

    public ArmSetAngle(ArmState state, double angle) {
        requires(arm);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (arm.state == state)
            return;
        arm.state = state;
        calcAngle();
        arm.setAngle(angle);
    }

    private void calcAngle() {
        if (state == ArmState.Custom)
            return;

        if (state == ArmState.FrontBallIn)
            angle = Const.kArmSetpointDegFrontBallIn;
        else if (state == ArmState.FrontBallCargo)
            angle = Const.kArmSetpointDegFrontBallCargo;
        else if (state == ArmState.FrontBallRocket)
            angle = Const.kArmSetpointDegFrontBallRocket;
        else if (state == ArmState.BackBallCargo)
            angle = Const.kArmSetpointDegBackBallCargo;
        else if (state == ArmState.BackBallRocket)
            angle = Const.kArmSetpointDegBackBallRocket;
        else if (state == ArmState.FrontHatchInOut)
            angle = Const.kArmSetpointDegFrontHatchInOut;
        else if (state == ArmState.BackHatchInOut)
            angle = Const.kArmSetpointDegBackHatchInOut;
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
