package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackHatchOut extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackHatchOut() {
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: BackHatchOut");
        prepCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Front, BallState.Stop, HatchState.Grab);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: BackHatchOut");
        execCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Front, BallState.Stop, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {

    }

}