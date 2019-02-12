package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Const;
import frc.robot.path.DriveMotorState;

public class DriveCalculator {
    public int gear;
    double prevTimestamp, prevPower;

    public DriveMotorState calculate(double power, double turn, int gear) {

        // deadband
        power = applyDeadband(power);
        turn = applyDeadband(turn);

        // ramp
        double dt = Timer.getFPGATimestamp() - prevTimestamp;
        prevTimestamp = Timer.getFPGATimestamp();
        prevPower = power;
        power = ramp(power, prevPower, dt);

        // gear
        power = applyPowerGear(power, gear);
        turn = applyTurnGear(turn, gear);

        double right = power + turn;
        double left = power - turn;

        return new DriveMotorState(left, right);
    }

    public void reset() {
        prevTimestamp = Timer.getFPGATimestamp();
    }

    private double applyDeadband(double value) {
        if (Math.abs(value) > Const.kDriveJoystickDeadband)
            return value;
        return 0;
    }

    private double calcMaxAccel(double dt) {
        return 1 / Const.maxAccelMSS * dt;
    }

    private double ramp(double value, double prevValue, double dt) {
        if (value - prevValue > calcMaxAccel(dt)) {
            value = prevValue + calcMaxAccel(dt);
        } else if (value - prevValue < -calcMaxAccel(dt)) {
            value = prevValue - calcMaxAccel(dt);
        }
        return value;
    }

    private double applyPowerGear(double speed, int gear) {
        return speed * Const.kDrivePowerGears[gear - 1];
    }

    private double applyTurnGear(double speed, int gear) {
        return speed * Const.kDriveTurnGears[gear - 1];
    }
}