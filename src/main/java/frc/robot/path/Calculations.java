package frc.robot.path;

public class Calculations {

    public static final double cimMotorFreeSpeed = 5330 / 60.0; // rotations per second
    public static final double wheelDiameter = 6.0 / 12.0; // meters
    public static final double gearboxRatio = 8.899; // 1:8.899

    public static final double maxVelocityTheory = // 15.68 ft/s
            (cimMotorFreeSpeed * Math.PI * wheelDiameter) / (gearboxRatio);

    public static final double batteryWeight = 12.5; // lb
    public static final double bumperWeight = 10.0; // lb
    public static final double robotWeight = 88.0; // lb
    public static final double totalWeight = (batteryWeight + bumperWeight + robotWeight) * 0.4536; // kg
    public static final double numberOfMotors = 4.0;
    public static final double cimMotorStallTorque = 2.41; // rotations per second

    public static final double maxAccelerationTheory = //
            (2 * numberOfMotors * cimMotorStallTorque * gearboxRatio) / (wheelDiameter * totalWeight);

    public static void main(String[] args) {
        System.out.println("maxVel: " + maxVelocityTheory);
        System.out.println("maxAcc: " + maxAccelerationTheory);
        RobotPathConfig a = RobotPathConfig.getRobotConfig();
    }
}