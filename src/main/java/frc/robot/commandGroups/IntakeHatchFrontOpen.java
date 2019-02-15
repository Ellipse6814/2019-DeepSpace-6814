package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.HatchIntakeSet;
import frc.robot.commands.JawSetAngle;

public class IntakeHatchFrontOpen extends CommandGroup {
    /**
     * Add your docs here.
     */
    public IntakeHatchFrontOpen() {
        addParallel(new ArmSetAngle(ArmState.FrontHatchInOut));
        addParallel(new JawSetAngle(JawState.Front));
        addParallel(new HatchIntakeSet(HatchState.Open));
    }
}
