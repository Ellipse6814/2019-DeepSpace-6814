package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Enums.ArmState;
import frc.robot.Enums.HatchState;
import frc.robot.Enums.JawState;
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
