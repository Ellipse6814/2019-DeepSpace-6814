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
        System.out.println("PREP: FrontBallHumanIn");
        prepCmd = new SetRobot(ArmState.FrontBallHumanIn, JawState.BallHuman, BallState.In, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: FrontBallHumanIn");
        execCmd = new SetRobot(ArmState.FrontBallHumanIn, JawState.BallHuman, BallState.Hold, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

}