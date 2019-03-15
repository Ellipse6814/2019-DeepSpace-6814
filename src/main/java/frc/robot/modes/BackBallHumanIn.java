package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackBallHumanIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackBallHumanIn() {
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: BackBallHumanIn");
        prepCmd = new SetRobot(ArmState.BackBallHumanIn, JawState.BallHuman, BallState.In, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: BackBallHumanIn");
        execCmd = new SetRobot(ArmState.BackBallHumanIn, JawState.BallHuman, BallState.Hold, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {

    }

}