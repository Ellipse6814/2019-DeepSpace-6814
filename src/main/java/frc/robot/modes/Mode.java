package frc.robot.modes;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public abstract class Mode extends Command {

    public boolean lastStage = true; // exec for true, false for prep. init true to trigger prep init
    private boolean isFinished = false;

    public Mode() {
        super();
    }

    abstract protected void modeInit();

    abstract protected void prepInit();

    abstract protected void prepLoop();

    abstract protected void execInit();

    abstract protected void execLoop();

    @Override
    protected void initialize() {
        modeInit();
        prepInit();
    }

    @Override
    protected void execute() {
        if (getExecButton()) {
            if (!lastStage) {
                lastStage = true;
                execInit();
            }
            execLoop();
        } else {
            if (lastStage) {
                lastStage = false;
                prepInit();
            }
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
        System.out.println("A mode has ended");
    }

    @Override
    protected void interrupted() {
        System.out.println("A mode was interrupted");
        end();
    }

    protected boolean getExecButton() {
        return Robot.oi.getExecButton();
    }
}
