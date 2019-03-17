package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackBallRocket extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackBallRocket() {
        super();
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: BackBallRocket");
        prepCmd = new SetRobot(ArmState.BackBallRocket, JawState.BallOut, BallState.Hold, HatchState.Grab);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: BackBallRocket");
        execCmd = new SetRobot(ArmState.BackBallRocket, JawState.BallOut, BallState.Out, HatchState.Grab);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {

    }

}