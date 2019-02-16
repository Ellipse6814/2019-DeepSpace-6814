package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class FrontBallHumanIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontBallHumanIn() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new SetRobot(ArmState.FrontBallHumanIn, JawState.Ball, BallState.In, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new SetRobot(ArmState.FrontBallHumanIn, JawState.Ball, BallState.Hold, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}