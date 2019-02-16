package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commandGroups.ExecHatchFrontIn;
import frc.robot.commandGroups.PrepHatchFrontIn;

public class FrontHatchIn extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontHatchIn() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new PrepHatchFrontIn();
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new ExecHatchFrontIn();
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}