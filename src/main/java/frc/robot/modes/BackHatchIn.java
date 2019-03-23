package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.SetRobot;

public class BackHatchIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    private boolean firstPrep;

    public BackHatchIn() {
        super();
    }

    @Override
    protected void modeInit() {
        firstPrep = true;
    }

    @Override
    protected void prepInit() {
        System.out.println("PREP: BackHatchIn");
        if (firstPrep == false) {
            System.out.println("2nd PREP: BackHatchIn: staying same");
            return;
        }
        firstPrep = false;
        prepCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop, HatchState.Grab); // grab and
                                                                                                         // release
                                                                                                         // switched to
                                                                                                         // be safe
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        System.out.println("EXEC: BackHatchIn");
        execCmd = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop, HatchState.Release);
        execCmd.start();
    }

    @Override
    protected void execLoop() {
    }
}