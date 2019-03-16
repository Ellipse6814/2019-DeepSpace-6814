package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Util.DriveState;
import frc.robot.subsystems.Drive;

public class DriveDPad extends Command {

    private Drive drive = Robot.drive;
    private OI oi = Robot.oi;

    public DriveDPad() {
        requires(drive);
    }

    @Override
    protected void initialize() {
        System.out.println("Driving with DPad!");
        Robot.drive.state = DriveState.DrivingDPad;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double pov = oi.getPOV();
        double power = 0, turn = 0;
        if (pov == 0) {
            power = 0.5;
            turn = 0;
        } else if (pov == 90) {
            power = 0;
            turn = -0.8;
        } else if (pov == 180) {
            power = -0.5;
            turn = 0;
        } else if (pov == 270) {
            power = 0;
            turn = 0.8;
        }
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
