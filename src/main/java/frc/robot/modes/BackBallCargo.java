package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackBallCargo extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackBallCargo() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new SetRobot(ArmState.BackBallCargo, JawState.Ball, BallState.Hold, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new SetRobot(ArmState.BackBallCargo, JawState.Ball, BallState.Out, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}

/*
 * this is how you create a in line command group
 * 
 * @Override protected void execInit() { execCmd = new CommandGroup() { {
 * addParallel(new ArmSetAngle(ArmState.FrontBallCargo)); addParallel(new
 * JawSetAngle(JawState.Ball)); addParallel(new BallIntakeSet(BallState.Out)); }
 * }; execCmd.start(); }
 *
 */