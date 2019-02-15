package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;
import frc.robot.subsystems.Arm;

public class IntakeBallFrontIn extends CommandGroup {
    Arm arm = Robot.arm;

    public IntakeBallFrontIn() {
        addParallel(new ArmSetAngle(ArmState.FrontBallIn));
        addParallel(new JawSetAngle(JawState.Idle));
        addParallel(new BallIntakeSet(BallState.In));
    }
}
