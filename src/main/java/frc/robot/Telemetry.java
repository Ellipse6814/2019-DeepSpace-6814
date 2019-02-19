package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.modes.*;

public class Telemetry {

    private static Telemetry instance;

    public static Telemetry getInstance() {
        if (instance == null)
            instance = new Telemetry();
        return instance;
    }

    public void updateGyro() {
        SmartDashboard.putNumber("Gyro", Robot.drive.getGyro());
    }

    public void updateEncoders() {
        SmartDashboard.putNumber("Left Encoder", Robot.drive.getLeftEncoder());
        SmartDashboard.putNumber("Right Encoder", Robot.drive.getRightEncoder());
        SmartDashboard.putNumber("Arm Encoder", Robot.arm.getEncoderPosition());
    }

    public void initSmartDashboardControlButtons() {
        SmartDashboard.putData("Front Ball Floor In", new FrontBallFloorIn());
        SmartDashboard.putData("Front Ball Human In", new FrontBallHumanIn());
        SmartDashboard.putData("Front Ball Cargo Out", new FrontBallCargo());
        SmartDashboard.putData("Front Ball Rocket Out", new FrontBallRocket());
        SmartDashboard.putData("Front Hatch In", new FrontHatchIn());
        SmartDashboard.putData("Front Hatch Out", new FrontHatchOut());

        SmartDashboard.putData("Back Ball Human In", new BackBallHumanIn());
        SmartDashboard.putData("Back Ball Cargo Out", new BackBallCargo());
        SmartDashboard.putData("Back Ball Rocket Out", new BackBallRocket());
        SmartDashboard.putData("Back Hatch In", new BackHatchIn());
        SmartDashboard.putData("Back Hatch Out", new BackHatchOut());

        SmartDashboard.putData("Middle Idle", new MiddleIdle());

    }

    public void initPIDTuner() {
        SmartDashboard.putNumber("Arm P", Const.kArmkP);
        SmartDashboard.putNumber("Arm I", Const.kArmkI);
        SmartDashboard.putNumber("Arm D", Const.kArmkD);
        SmartDashboard.putNumber("Arm F", Const.kArmkF);
        SmartDashboard.putNumber("Jaw P", Const.kJawkP);
        SmartDashboard.putNumber("Jaw I", Const.kJawkI);
        SmartDashboard.putNumber("Jaw D", Const.kJawkD);
        SmartDashboard.putNumber("Jaw F", Const.kJawkF);
    }
}
