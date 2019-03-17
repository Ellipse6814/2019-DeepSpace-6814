package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;
import frc.robot.subsystems.BallIntake;

public class FrontBallFloorIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    private BallIntake intake = Robot.ballIntake;

    private int considerBallInCount;

    public FrontBallFloorIn() {
        super();
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: FrontBallFloorIn");
        prepCmd = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball, BallState.Hold, HatchState.Grab);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: FrontBallFloorIn");
        considerBallInCount = 0;
        execCmd = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball, BallState.In, HatchState.Grab);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
        if (intake.rollerMotor.getOutputCurrent() > Const.kBallIntakeConsiderBallInAmp) {
            considerBallInCount++;
            System.out.println("considerBallInCount" + considerBallInCount);
        }
        if (considerBallInCount >= Const.kBallIntakeConsiderBallInCount) {
            // prepCmd = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball,
            // BallState.Hold, HatchState.Grab);
            // prepCmd.start();
            System.out.println("STOPPING ROLLERS BECAUSE BALL IS IN");
        }
    }

    @Override
    protected void modeInit() {
    }

}