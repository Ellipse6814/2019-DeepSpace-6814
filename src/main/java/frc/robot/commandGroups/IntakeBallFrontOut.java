package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.EvalEqual;
import frc.robot.Util.Evaluate;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;
import frc.robot.commands.WaitUntil;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Jaw;

public class IntakeBallFrontOut extends CommandGroup {

    private Arm arm = Robot.arm;
    private Jaw jaw = Robot.jaw;

    public IntakeBallFrontOut(boolean reqSlow, Evaluate senderReady) {
        addParallel(new ArmSetAngle(ArmState.FrontBallOut));
        addParallel(new JawSetAngle(JawState.Idle));

        addSequential(new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                if (arm.onTarget() && jaw.onTarget() && senderReady.evaluate())
                    return true;
                return false;
            }
        }));

        if (reqSlow)
            addParallel(new BallIntakeSet(BallState.OutSlow));
        else
            addParallel(new BallIntakeSet(BallState.Out));

    }

    public IntakeBallFrontOut() {
        this(false, new EvalEqual(true));
    }
}









