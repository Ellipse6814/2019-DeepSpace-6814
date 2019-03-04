package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class FrontBallFloorIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontBallFloorIn() {
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: FrontBallFloorIn");
        prepCmd = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball, BallState.Hold, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: FrontBallFloorIn");
        execCmd = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball, BallState.In, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

}