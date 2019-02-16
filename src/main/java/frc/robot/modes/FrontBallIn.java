package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commandGroups.ExecBallFrontFloorIn;
import frc.robot.commandGroups.PrepBallFrontFloorIn;

public class FrontBallIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontBallIn() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new PrepBallFrontFloorIn();
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new ExecBallFrontFloorIn();
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return execCmd.isCompleted();
    }

}