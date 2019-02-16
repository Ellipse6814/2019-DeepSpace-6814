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

    private Encoder leftEncoder, rightEncoder;

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

    @Deprecated
    private void initEncoders() {
        final double kDriveWheelDiameter = 0.152; // meters
        final double kDriveGearboxRatio = 1 / 1.0;
        final double kDriveRotation2Distance = (kDriveGearboxRatio) * (Math.PI * kDriveWheelDiameter);
        // final double kDriveRotation2Distance = (kDriveGearboxRatio) * (0.4616);
        final double kDrivePulse2Distance = kDriveRotation2Distance / 128;

        leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        leftEncoder.setMaxPeriod(1); // regard motor as stopped if no movement for 0.2 seconds
        leftEncoder.setMinRate(0); // regard motor as stopped if distance per second < 10
        leftEncoder.setDistancePerPulse(kDrivePulse2Distance); // the scaling constant that converts pulses
        // into distance
        leftEncoder.setSamplesToAverage(5); // used to reduce noise in period
        leftEncoder.reset();

        // ---------------------------------------------------

        rightEncoder = new Encoder(1, 0, false, EncodingType.k4X);
        rightEncoder.setMaxPeriod(1); // regard motor as stopped if no movement for 0.2 seconds
        rightEncoder.setMinRate(0); // regard motor as stopped if distance per second < 10
        rightEncoder.setDistancePerPulse(kDrivePulse2Distance); // the scaling constant that converts pulses
        // into distance
        rightEncoder.setSamplesToAverage(5); // used to reduce noise in period
        rightEncoder.reset();
    }

    public double getEncoders() {
        return (leftEncoder.get() + rightEncoder.get()) / 2;
    }

    public double getGyro() {
        return gyro.getAngle() - gyroZero;
    }

    public void zeroEncoder() {
        leftEncoder.reset();
        rightEncoder.reset();
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
        return leftEncoder.getDistance();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
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
