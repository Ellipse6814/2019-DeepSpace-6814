package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.MotorDirection;

public class BallIntake extends Subsystem {

    private static BallIntake instance;

    public static BallIntake getInstance() {
        if (instance == null) {
            instance = new BallIntake();
        }
        return instance;
    }

    private TalonSRX rollerMotor;
    private int maxAmp = 10;

    private BallIntake() {
        initTalons();
    }

    private void initTalons() {
        rollerMotor = new TalonSRX(Const.kIntakeRollerMotorPort);
        rollerMotor.setInverted(false);
        rollerMotor.enableVoltageCompensation(true);

        // rollerMotor.configPeakCurrentDuration(100, 10); // 100ms /
        rollerMotor.configPeakCurrentDuration(0, Const.kTalonCommTimeout); // don't allow peak
        rollerMotor.configContinuousCurrentLimit(10, Const.kTalonCommTimeout);
        rollerMotor.enableCurrentLimit(true); // turn it on

        // config current PID
        rollerMotor.configAllowableClosedloopError(0, 0, 10);

        rollerMotor.config_kP(0, 2, 10);
        rollerMotor.config_kI(0, 0, 10);
        rollerMotor.config_kD(0, 0, 10);
        rollerMotor.config_kF(0, 1, 10);
    }

    public void setMaxAmp(int maxAmp) {
        rollerMotor.configContinuousCurrentLimit(maxAmp, Const.kTalonCommTimeout);
    }

    @Deprecated
    public void setCurrentPID(MotorDirection direction, int amps) {
        if (amps < 0.001)
            rollerMotor.set(ControlMode.PercentOutput, 0);
        if (direction == MotorDirection.Backward)
            amps *= -1;
        rollerMotor.set(ControlMode.Current, amps);
    }

    public void setMotor(MotorDirection direction, double speed, int amp) {
        if (maxAmp != amp)
            setMaxAmp(amp);
        if (direction == MotorDirection.Backward)
            speed *= -1;
        rollerMotor.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
