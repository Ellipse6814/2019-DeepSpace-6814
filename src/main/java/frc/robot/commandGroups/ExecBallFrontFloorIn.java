package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;

public class ExecBallFrontFloorIn extends CommandGroup {

    public ExecBallFrontFloorIn() {
        addParallel(new ArmSetAngle(ArmState.Middle));
        addParallel(new JawSetAngle(JawState.Ball));
        addParallel(new BallIntakeSet(BallState.Hold));
    }
}
