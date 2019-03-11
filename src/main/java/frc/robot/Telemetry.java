package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Util.Evaluate;
import frc.robot.commands.ArmReset;
import frc.robot.commands.WaitUntil;
import frc.robot.modes.*;

public class Telemetry {

    private static Telemetry instance;

    public static Telemetry getInstance() {
        if (instance == null)
            instance = new Telemetry();
        return instance;
    }

    private Telemetry() {
        initSmartDashboardControlButtons();
        initRawResetSensors();
        initPIDTest();
        initPIDTuner();
    }

    public void update() {
        updateEncoders();
        updateGyro();
        displayPIDError();
    }

    public void displayPIDError() {
        SmartDashboard.putNumber("PID Error Value", Robot.arm.getPIDError());
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

        SmartDashboard.putData("Reset Arm CMD", new ArmReset());

    }

    public void initPIDTest() {
        SmartDashboard.putData("Arm PID Setpoint 30", new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                Robot.arm.setAngle(30);
                return true;
            }
        }));
        SmartDashboard.putData("Arm PID Setpoint 80", new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                Robot.arm.setAngle(80);
                return true;
            }
        }));
        SmartDashboard.putData("Arm PID Setpoint 130", new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                Robot.arm.setAngle(130);
                return true;
            }
        }));
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

    public void initRawResetSensors() {
        SmartDashboard.putData("Zero Arm Encoder", new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                Robot.arm.resetEncoder();
                return true;
            }
        }));
        SmartDashboard.putData("Zero Drive Encoders", new WaitUntil(new Evaluate() {
            public boolean evaluate() {
                Robot.drive.zeroEncoder();
                return true;
            }
        }));
    }
}
