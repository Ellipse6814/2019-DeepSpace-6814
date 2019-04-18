package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class SetStage extends Command {

    private String stage;
    private String wantedStage;

    public SetStage(String stage, String wantedStage) {
        this.stage = stage; // THIS IS BY REFERENCE
        this.wantedStage = wantedStage;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        stage = wantedStage;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
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
