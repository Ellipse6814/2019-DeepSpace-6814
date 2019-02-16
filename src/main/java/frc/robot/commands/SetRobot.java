package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;

public class SetRobot extends CommandGroup {

    public SetRobot(ArmState arm, JawState jaw, BallState ball, HatchState hatch) {
        addParallel(new ArmSetAngle(arm));
        addParallel(new JawSetAngle(jaw));
        addParallel(new BallIntakeSet(ball));
        addParallel(new HatchIntakeSet(hatch));
    }
}
