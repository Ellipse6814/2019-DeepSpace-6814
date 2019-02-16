package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.JawState;
import frc.robot.commandGroups.PrepBallFrontCargo;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;

public class FrontBallCargo extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontBallCargo() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new PrepBallFrontCargo();
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new CommandGroup() {
            {
                addParallel(new ArmSetAngle(ArmState.FrontBallCargo));
                addParallel(new JawSetAngle(JawState.Ball));
                addParallel(new BallIntakeSet(BallState.Out));
            }
        };
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}