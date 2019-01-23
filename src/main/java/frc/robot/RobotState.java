package frc.robot;

public class RobotState {

    private static RobotState instance;

    public static RobotState getInstance() {
        if (instance == null)
            instance = new RobotState();
        return instance;
    }

    public IntakeState intakeState;
    public DriveState driveState;
    public ArmState armState;
}

enum IntakeState {
    Open, Close
}

enum DriveState {
    Teleop, PID, PathFollowing
}

enum ArmState {
    OpenLoop, PID, MotionMagic
}