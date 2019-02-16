package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackHatchIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackHatchIn() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Front, BallState.Stop, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Front, BallState.Stop, HatchState.Grab);
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}