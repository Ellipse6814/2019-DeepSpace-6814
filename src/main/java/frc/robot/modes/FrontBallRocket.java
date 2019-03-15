package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class FrontBallRocket extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontBallRocket() {
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: FrontBallRocket");
        prepCmd = new SetRobot(ArmState.FrontBallRocket, JawState.BallOut, BallState.Hold, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: FrontBallRocket");
        execCmd = new SetRobot(ArmState.FrontBallRocket, JawState.BallOut, BallState.Out, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {

    }

}