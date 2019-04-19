package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.BallState;
import frc.robot.Util.MotorDirection;
import frc.robot.Util.TalonHelper;
import frc.robot.commands.DoNothing;

public class BallIntake extends Subsystem {

    private static BallIntake instance;

    public static BallIntake getInstance() {
        if (instance == null) {
            instance = new BallIntake();
        }
        return instance;
    }

    public TalonSRX rollerMotor;
    public BallState state;
    private int maxAmp = 10;

    private double lastSafeTimestamp = 0;

    private BallIntake() {
        initTalons();
    }

    private void initTalons() {
        rollerMotor = TalonHelper.createTalon(Const.kIntakeRollerMotorPort, Const.kIntakeRollerMotorInverted);
        TalonHelper.configCurrentLimit(rollerMotor, 10); // this subsystem is special on currents
        TalonHelper.configNeutralMode(rollerMotor, NeutralMode.Brake);

    }

    public void setMaxAmp(int maxAmp) {
        this.maxAmp = maxAmp;
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

    public void set(BallState wantedState) {
        if (state == wantedState)
            return;

        state = wantedState;
    }

    @Override
    public void periodic() {
        // System.out.println(state);
        if (state == BallState.In) {
            setMotor(MotorDirection.Forward, Const.kBallIntakeSpd, Const.kBallIntakeStallAmp);
        } else if (state == BallState.Out) {
            setMotor(MotorDirection.Backward, Const.kBallOuttakeSpd, Const.kBallIntakeNormalAmp);
        } else if (state == BallState.OutSlow) {
            setMotor(MotorDirection.Backward, Const.kBallIntakeSpdSlow, Const.kBallIntakeNormalAmp);
        } else if (state == BallState.Hold) {
            // if (Timer.getFPGATimestamp() % 1000 < 400)
            setMotor(MotorDirection.Forward, Const.kBallIntakeHoldSpd, Const.kBallIntakeStallAmp);
        } else if (state == BallState.Custom) {
            // MotorDirection md = intake ? MotorDirection.Backward :
            // MotorDirection.Forward;
            // setMotor(md, speed, amp);
            System.out.println("BALL INTAKE CUSTOM NOT IMPLEMENTED");
        } else { // if (state == BallState.Stop) {
            setMotor(MotorDirection.Forward, 0, 10);
        }
        checkSafety();
    }

    private void checkSafety() {
        if (Timer.getFPGATimestamp() - lastSafeTimestamp > 4) {// unsafe -> stop motor
            set(BallState.Hold);
        }

        if (rollerMotor.getOutputCurrent() < 60.0) {
            lastSafeTimestamp = Timer.getFPGATimestamp();
        }
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DoNothing(this)); // Do nothing with this subsystem, but still require it
    }
}
