package frc.robot.path;

public class RobotPathConfig {

    /**
     * This class groups all the hardware-specific path-following constants
     * together. The advantage is when we change robots (from practice bot to
     * official bot), we update our code quickly.
     */

    public double maxVel;// max vel the robot will follow at
    public double physicalMaxVel; // max vel hardware can support
    public double maxAcc;// max acceleration wanted to follow at
    public double maxAngVel;// max angular accel wanted to follow at
    public double spacing; // path waypoint spacing
    public double lookAheadDistance;// distance to find lookahead point
    public double trackWidth;// track width between left, right wheels (make 1-3 inches bigger)
    public double targetTolerance; // how close to the target is considered finished
    public double kP; // porportional constant for PIDVA motor output
    public double kV; // velocity constant for PIDVA motor output
    public double kA; // acceleration constant for PIDVA motor output
    public double kFF; // feedforward term (constant output to counter friction)

    // private static RobotPathConfig practiceRobotConfig;

    // this generates a NEW object that contains all the configs for the practice
    // bot when it is driving on carpet
    public static RobotPathConfig getPracticeRobotConfig() {
        RobotPathConfig practiceRobotConfig = new RobotPathConfig();
        practiceRobotConfig.maxVel = Units.ft2m(9); // 7 before
        practiceRobotConfig.maxAcc = Units.ft2m(4); // m/sec every sec
        practiceRobotConfig.spacing = Units.ft2m(1);
        practiceRobotConfig.maxAngVel = 2; // radians per second
        practiceRobotConfig.lookAheadDistance = Units.ft2m(1.8);
        practiceRobotConfig.trackWidth = Units.in2m(25);// 23 inches
        practiceRobotConfig.targetTolerance = Units.in2m(2);// m
        practiceRobotConfig.physicalMaxVel = Units.ft2m(12);
        practiceRobotConfig.kV = 1 / practiceRobotConfig.physicalMaxVel;
        practiceRobotConfig.kA = 2 / 9;
        practiceRobotConfig.kP = 0.2;
        practiceRobotConfig.kFF = 0.0;
        return practiceRobotConfig;
    }

    public static RobotPathConfig getRobotCharConfig() {
        RobotPathConfig robotConfig = new RobotPathConfig();
        robotConfig.maxVel = Units.ft2m(8); // 7 before
        robotConfig.maxAcc = Units.ft2m(6); // m/sec every sec
        robotConfig.spacing = Units.ft2m(1);
        robotConfig.maxAngVel = 2; // radians per second
        robotConfig.lookAheadDistance = Units.ft2m(1.7);
        robotConfig.trackWidth = Units.in2m(22);// really 22 inches
        robotConfig.targetTolerance = Units.in2m(40);
        robotConfig.physicalMaxVel = Units.ft2m(12);
        robotConfig.kV = 0.0604;
        robotConfig.kA = 0.00115;
        robotConfig.kP = 0.000109;
        robotConfig.kFF = 0.03;
        return robotConfig;
    }

    public static RobotPathConfig getRobotConfig() {
        RobotPathConfig robotConfig = new RobotPathConfig();
        robotConfig.maxVel = Units.ft2m(8); // 7 before
        robotConfig.maxAcc = Units.ft2m(6); // m/sec every sec
        robotConfig.spacing = Units.ft2m(1);
        robotConfig.maxAngVel = 2; // radians per second
        robotConfig.lookAheadDistance = Units.ft2m(1.7);
        robotConfig.trackWidth = Units.in2m(22);// really 22 inches
        robotConfig.targetTolerance = Units.in2m(40);
        robotConfig.physicalMaxVel = Units.ft2m(12);
        robotConfig.kV = 0.198;
        robotConfig.kA = 0.00377;
        robotConfig.kP = 0;
        robotConfig.kFF = 0.11167;
        return robotConfig;
    }

    public static RobotPathConfig getOldRobotConfig() {
        RobotPathConfig robotConfig = new RobotPathConfig();
        robotConfig.maxVel = Units.ft2m(8); // 7 before
        robotConfig.maxAcc = Units.ft2m(3); // m/sec every sec
        robotConfig.spacing = Units.ft2m(1);
        robotConfig.maxAngVel = 2; // radians per second
        robotConfig.lookAheadDistance = Units.ft2m(1.7);
        robotConfig.trackWidth = Units.in2m(22);// really 22 inches
        robotConfig.targetTolerance = Units.in2m(40);
        robotConfig.physicalMaxVel = Units.ft2m(16);
        robotConfig.kV = 1.1 / robotConfig.physicalMaxVel;
        robotConfig.kA = 1.2 / 9;
        robotConfig.kP = 0;
        robotConfig.kFF = 0.05;
        return robotConfig;
    }
}