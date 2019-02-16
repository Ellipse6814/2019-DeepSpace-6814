package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class FrontHatchOut extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontHatchOut() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop, HatchState.Grab);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}