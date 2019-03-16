package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class FrontHatchIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    private boolean firstPrep;

    public FrontHatchIn() {
    }

    @Override
    protected void prepInit() {
        if (firstPrep == false) {
            System.out.println("2nd PREP: FrontHatchIn: staying same");
            return;
        }
        firstPrep = false;
        System.out.println("PREP: FrontHatchIn");
        prepCmd = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop, HatchState.Release);
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: FrontHatchIn");
        execCmd = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop, HatchState.Grab);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }

    @Override
    protected void modeInit() {
        firstPrep = true;
    }

}