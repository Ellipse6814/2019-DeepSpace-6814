package frc.robot.subsystems;

import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Const;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Util.DriveState;
import frc.robot.Util.TalonHelper;
import frc.robot.commands.Drive2Joy;
import frc.robot.commands.DriveDPad;
import frc.robot.path.DriveMotorState;
import frc.robot.path.Odometer;

public class Drive extends Subsystem {
    public TalonSRX leftMaster, rightMaster;
    public VictorSPX leftSlave, rightSlave;

    public AHRS gyro;
    private double gyroZero = 0;

    private int gear = 3;

    public DriveState state = DriveState.Disabled;

    private DriveCalculator driveCalculator = new DriveCalculator();
    private Odometer odometer = Odometer.getInstance();

    private static Drive instance;

    public static Drive getInstance() {
        if (instance == null)
            instance = new Drive();
        return instance;
    }

    private Drive() {
        initGyro();
        initTalons();
        checkGearError();
    }

    public void drive(double left, double right) {
        leftMaster.set(ControlMode.PercentOutput, left);
        rightMaster.set(ControlMode.PercentOutput, right);
    }

    public void driveJoystick(double power, double turn) {
        DriveMotorState state = driveCalculator.calculate(power, turn, gear);
        drive(state.leftVel, state.rightVel);
    }

    private void checkGearError() {
        if (Const.kDrivePowerGears.length != Const.kDriveTurnGears.length) {
            System.out.println("!!!!!!!!!!!! Gear Array Bounds Non-match !!!!!!!!!!!!!!");
        }
    }

    private void initTalons() {

        rightMaster = TalonHelper.createTalon(Const.kDriveRightMasterMotorPort, Const.kDriveRightMasterMotorInverted);
        leftMaster = TalonHelper.createTalon(Const.kDriveLeftMasterMotorPort, Const.kDriveLeftMasterMotorInverted);

        rightSlave = TalonHelper.createSlaveVictor(Const.kDriveRightSlaveMotorPort, rightMaster);
        leftSlave = TalonHelper.createSlaveVictor(Const.kDriveLeftSlaveMotorPort, leftMaster);

        TalonHelper.configCurrentLimit(rightMaster, Const.kDriveMotorMaxAmp);
        TalonHelper.configCurrentLimit(leftMaster, Const.kDriveMotorMaxAmp);

        TalonHelper.configNeutralMode(rightMaster, NeutralMode.Brake);
        TalonHelper.configNeutralMode(leftMaster, NeutralMode.Brake);
        // TalonHelper.configNeutralMode(Arrays.asList(rightMaster, leftMaster,
        // rightSlave, leftSlave), NeutralMode.Brake);

        TalonHelper.configDeadband(Arrays.asList(rightMaster, leftMaster, rightSlave, leftSlave),
                Const.kDriveJoystickDeadband);

        TalonHelper.configMagEncoder(rightMaster, Const.kDriveRightEncoderInverted);
        TalonHelper.configMagEncoder(leftMaster, Const.kDriveLeftEncoderInverted);
    }

    private void initGyro() {
        try {
            // gyro = new AHRS(SPI.Port.kMXP);
            gyro = new AHRS(SPI.Port.kMXP);
            // gyro = new AHRS(SerialPort.Port.kUSB);
            zeroGyro();
        } catch (RuntimeException ex) {
            System.out.println("Error instantiating navX-MXP:  " + ex.getMessage());
        }
    }

    public double getEncoders() {
        return (getLeftEncoder() + getRightEncoder()) / 2;
    }

    public double getGyro() {
        // double yaw = gyro.getYaw();
        // SmartDashboard.putNumber("Yaw", yaw);
        return gyro.getAngle() - gyroZero;
    }

    public void zeroEncoder() {
        leftMaster.setSelectedSensorPosition(0);
        rightMaster.setSelectedSensorPosition(0);
        odometer.reset();
    }

    public void resetSensors() {
        zeroGyro();
        zeroEncoder();
    }

    public void zeroGyro() {
        zeroGyro(0);
    }

    public void zeroGyro(double setCurrentAngleTo) {
        gyroZero = gyro.getAngle() + setCurrentAngleTo;
    }

    public double getLeftEncoder() {
        return leftMaster.getSelectedSensorPosition(0) * Const.kTalon4096Unit2Deg / 360 * Math.PI * 6 * 0.0254;
    }

    public double getRightEncoder() {
        return rightMaster.getSelectedSensorPosition(0) * Const.kTalon4096Unit2Deg / 360 * Math.PI * 6 * 0.0254;
    }

    public void gearUp() {
        if (gear < Const.kDrivePowerGears.length - 1)
            gear++;
        System.out.println("Gear+ " + gear);
    }

    public void gearDown() {
        if (gear > 0)
            gear--;
        System.out.println("Gear- " + gear);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive2Joy());
    }

    @Override
    public void periodic() {
        super.periodic();
        updateOdometer();
        OI oi = Robot.oi;

        if (state != DriveState.DrivingJoystick
                && (Math.abs(oi.getDrivePower()) >= 0.5 || Math.abs(oi.getDriveTurn()) >= 0.5)) {
            Command driveCommand = new Drive2Joy();
            driveCommand.start();
        } else if (state != DriveState.DrivingDPad && (oi.getPOV() != -1)) {
            Command driveCommand = new DriveDPad();
            driveCommand.start();
        }
    }

    public void updateOdometer() {
        odometer.update(getLeftEncoder(), getRightEncoder(), getGyro());
    }

    public void disable() {
        TalonHelper.configNeutralMode(Arrays.asList(leftMaster, leftSlave, rightMaster, rightSlave), NeutralMode.Coast);
    }

    public void enable() {
        TalonHelper.configNeutralMode(Arrays.asList(leftMaster, leftSlave, rightMaster, rightSlave), NeutralMode.Brake);
    }
}
