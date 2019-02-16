package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.HatchIntakeSet;
import frc.robot.commands.JawSetAngle;

@Deprecated
public class ExecHatchFrontOut extends CommandGroup {

    public ExecHatchFrontOut() {
        addParallel(new ArmSetAngle(ArmState.FrontHatchInOut));
        addParallel(new JawSetAngle(JawState.Front));
        addParallel(new HatchIntakeSet(HatchState.Release));
    }
}
