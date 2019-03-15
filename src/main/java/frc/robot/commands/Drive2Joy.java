package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Util.DriveState;
import frc.robot.subsystems.Drive;

public class Drive2Joy extends Command {

    private Drive drive = Robot.drive;
    private OI oi = Robot.oi;

    public Drive2Joy() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        drive.state = DriveState.Driving;
        System.out.println("Driving with 2 joysticks!");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double power = oi.getDrivePower();
        double turn = oi.getDriveTurn();
        drive.driveJoystick(power, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
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
