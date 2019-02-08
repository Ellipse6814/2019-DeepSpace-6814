/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Enums.ArmState;
import frc.robot.Enums.JawState;
import frc.robot.Enums.MotorDirection;

public class Arm extends Subsystem {

    private static Arm instance;
    public ArmState state;

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private DigitalInput armHallEffectFront = new DigitalInput(Const.kArmHallEffectFrontSensorPort);
    private DigitalInput armHallEffectBack = new DigitalInput(Const.kArmHallEffectBackSensorPort);

    private TalonSRX armMotor;
    private VictorSPX armMotorSlave;

    private Arm() {
        initTalons();
    }

    private void initTalons() {
        armMotor = new TalonSRX(Const.kArmMotorPort);
        armMotor.setInverted(false);
        armMotor.enableVoltageCompensation(true);
        armMotor.configContinuousCurrentLimit(30, 100);
        armMotor.configPeakCurrentLimit(0);

        armMotorSlave = new VictorSPX(Const.kArmMotorSlavePort);
        armMotorSlave.follow(armMotor);
        armMotorSlave.setInverted(InvertType.FollowMaster);
        armMotorSlave.enableVoltageCompensation(true);

        // TODO: configure PID
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = Const.getTalon4096Units(angle);
        armMotor.set(ControlMode.Position, targetPositionRotations);
    }

    public void setOpenLoop(double speed, MotorDirection direction) {
        if (direction == MotorDirection.Forward) {
            armMotor.set(ControlMode.PercentOutput, speed);
        } else {
            armMotor.set(ControlMode.PercentOutput, -speed);
        }
    }

    public boolean getFrontHallEffect() {
        return armHallEffectFront.get();
    }

    public boolean getBackHallEffect() {
        return armHallEffectBack.get();
    }

    public void resetEncoder() {
        // TODO:
    }

    // public void setArmFront() {
    // setArmAngle(Const.kArmSetpointDegFront);
    // }

    // public void setArmBack() {
    // setArmAngle(Const.kArmSetpointDegBack);
    // }

    // public void setArmMiddle() {
    // setArmAngle(Const.kArmSetpointDegMiddle);
    // }

    // public void setArmCustom(double angle) {
    // setArmAngle(angle);
    // }

    @Override
    public void initDefaultCommand() {

    }
}
