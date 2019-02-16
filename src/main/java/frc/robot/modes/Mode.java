package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public abstract class Mode extends Command {

    public boolean firstTimeExec = true;
    private boolean isFinished = false;

    public boolean execStage = false;

    public Mode() {
        super();
    }

    abstract protected void prepInit();

    abstract protected void prepLoop();

    abstract protected void execInit();

    abstract protected boolean execLoop(); // return true to finish()

    @Override
    protected void initialize() {
        prepInit();
    }

    @Override
    protected void execute() {
        execStage = (execStage || getExecButton());

        if (execStage) {
            if (firstTimeExec) {
                firstTimeExec = false;
                execInit();
            }
            if (execLoop())
                finish();
        } else {
            prepLoop();
        }
    }

    public void finish() {
        isFinished = true;
    }

    @Override
    protected boolean isFinished() {
        return isFinished;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
        end();
    }

    protected boolean getExecButton() {
        return Robot.oi.getExecButton();
    }
}
