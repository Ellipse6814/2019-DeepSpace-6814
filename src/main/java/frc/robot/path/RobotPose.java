package frc.robot.path;

public class RobotPose {
    public Point position;
    public double angle; // in degrees

    public RobotPose(Point position, double angle) {
        this.position = position;
        this.angle = angle;
    }

    public RobotPose() {
        position = new Point();
        angle = 0;
    }
}