package frc.robot.Util;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class TalonHelper {

    public static final int kCommTimeout = 10; // ms

    public static TalonSRX createTalon(int port, boolean inverted) {
        TalonSRX talon = new TalonSRX(port);
        talon.setInverted(inverted);
        talon.enableVoltageCompensation(true);
        System.out.println("A TalonSRX is created on port [" + port + "], with inverted [" + inverted + "]");
        return talon;
    }

    public static TalonSRX createSlaveTalon(int port, TalonSRX master) {
        TalonSRX talon = new TalonSRX(port);
        talon.follow(master);
        talon.setInverted(InvertType.FollowMaster);
        System.out.println(
                "A SLAVE TalonSRX is created on port [" + port + "], with inverted [" + master.getInverted() + "]");
        return talon;
    }

    public static VictorSPX createSlaveVictor(int port, TalonSRX master) {
        VictorSPX victor = new VictorSPX(port);
        victor.follow(master);
        victor.setInverted(InvertType.FollowMaster);
        System.out.println(
                "A SLAVE VictorSRX is created on port [" + port + "], with inverted [" + master.getInverted() + "]");
        return victor;
    }

    public static void configMagEncoder(TalonSRX talon, boolean phase) {
        talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kCommTimeout);
        talon.setSensorPhase(phase);
    }

    public static void configQuadEncoder(TalonSRX talon, boolean phase) {
        talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, kCommTimeout);
        talon.setSensorPhase(phase);
    }

    public static void configCurrentLimit(TalonSRX talon, int amps) {
        talon.configContinuousCurrentLimit(amps, kCommTimeout);
        talon.configPeakCurrentLimit(0);
    }

    public static void configNeutralMode(TalonSRX talon, NeutralMode mode) {
        talon.setNeutralMode(mode);
    }

    public static void configDeadband(TalonSRX talon, double percent) {
        talon.configNeutralDeadband(percent);
    }

    public static void configPID(TalonSRX talon, int slot, double p, double i, double d, double f) {
        talon.config_kP(slot, p, kCommTimeout);
        talon.config_kI(slot, i, kCommTimeout);
        talon.config_kD(slot, d, kCommTimeout);
        talon.config_kF(slot, f, kCommTimeout);
    }
}