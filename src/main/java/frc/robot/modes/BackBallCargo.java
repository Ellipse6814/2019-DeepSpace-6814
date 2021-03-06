package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackBallCargo extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public BackBallCargo() {
        super();
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: BackBallCargo");
        prepCmd = new SetRobot(ArmState.BackBallCargo, JawState.BallOut, BallState.Hold, HatchState.Grab);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: BackBallCargo");
        execCmd = new SetRobot(ArmState.BackBallCargo, JawState.BallOut, BallState.Out, HatchState.Grab);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {

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