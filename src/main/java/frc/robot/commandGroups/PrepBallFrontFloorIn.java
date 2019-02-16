package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;

public class PrepBallFrontFloorIn extends CommandGroup {

    public PrepBallFrontFloorIn() {
        addParallel(new ArmSetAngle(ArmState.FrontBallIn));
        addParallel(new JawSetAngle(JawState.Ball));
        addParallel(new BallIntakeSet(BallState.In));
    }
}
