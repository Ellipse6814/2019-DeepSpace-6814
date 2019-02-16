package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;

public class PrepBallFrontCargo extends CommandGroup {

    public PrepBallFrontCargo() {
        addParallel(new ArmSetAngle(ArmState.FrontBallCargo));
        addParallel(new JawSetAngle(JawState.Ball));
        addParallel(new BallIntakeSet(BallState.Hold));
    }
}
