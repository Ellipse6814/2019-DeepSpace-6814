package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commandGroups.ExecHatchFrontOut;
import frc.robot.commandGroups.PrepHatchFrontOut;

public class FrontHatchOut extends Mode {

    private Command prepCmd;
    private Command execCmd;

    public FrontHatchOut() {
    }

    @Override
    protected void prepInit() {
        prepCmd = new PrepHatchFrontOut();
        prepCmd.start();
    }

    @Override
    protected void prepLoop() {
    }

    @Override
    protected void execInit() {
        execCmd = new ExecHatchFrontOut();
        execCmd.start();
    }

    @Override
    protected boolean execLoop() {
        return !getExecButton();
    }

}