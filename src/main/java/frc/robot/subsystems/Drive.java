package frc.robot.subsystems;

import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.TalonHelper;
import frc.robot.path.DriveMotorState;
import frc.robot.path.Odometer;

public class Drive extends Subsystem {
    public TalonSRX leftMaster, rightMaster;
    public VictorSPX leftSlave, rightSlave;

    private AHRS gyro;
    private double gyroZero = 0;

    private int gear = 2;

    private DriveCalculator driveCalculator = new DriveCalculator();

    private static Drive instance;

    public static Drive getInstance() {
        if (instance == null)
            instance = new Drive();
        return instance;
    }

    private Drive() {
        initGyro();
        // initEncoders(); // TODO: we are going to use new encoders!!!
        initTalons();
        checkGearError();
    }

    @Override
    protected void initDefaultCommand() {

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

        rightMaster = TalonHelper.createTalon(Const.kDriveRightMasterMotorPort, false); // TODO:
        leftMaster = TalonHelper.createTalon(Const.kDriveLeftMasterMotorPort, true);

        rightSlave = TalonHelper.createSlaveVictor(Const.kDriveRightSlaveMotorPort, rightMaster);
        leftSlave = TalonHelper.createSlaveVictor(Const.kDriveLeftSlaveMotorPort, leftMaster);

        TalonHelper.configCurrentLimit(rightMaster, 50);
        TalonHelper.configCurrentLimit(leftMaster, 50);

        TalonHelper.configNeutralMode(Arrays.asList(rightMaster, leftMaster, rightSlave, leftSlave), NeutralMode.Brake);

        TalonHelper.configDeadband(Arrays.asList(rightMaster, leftMaster, rightSlave, leftSlave), 0.04);

        TalonHelper.configMagEncoder(rightMaster, true);// TODO:
        TalonHelper.configMagEncoder(leftMaster, true);// TODO:
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
        return gyro.getAngle() - gyroZero;
    }

    public void zeroEncoder() {
        leftMaster.setSelectedSensorPosition(0);
        rightMaster.setSelectedSensorPosition(0);
        Odometer.getInstance().reset();
    }

    public void resetSensors() {
        zeroGyro();
        zeroEncoder();
    }

    public void zeroGyro() {
        gyroZero = gyro.getAngle();
    }

    public double getLeftEncoder() {
        return Const.talon4096Unit2Deg(leftMaster.getSelectedSensorPosition(0));
    }

    public double getRightEncoder() {
        return Const.talon4096Unit2Deg(rightMaster.getSelectedSensorPosition(0));
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
}
