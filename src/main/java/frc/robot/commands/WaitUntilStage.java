package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class WaitUntilStage extends Command {

    private String stage;
    private String wantedStage;
    private boolean isFinished = false;

    public WaitUntilStage(String stage, String wantedStage) {
        this.stage = stage; // THIS IS BY REFERENCE
        this.wantedStage = wantedStage;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (stage == wantedStage) {
            System.out.println("Stage == wantedStage == [" + wantedStage + "]");
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
