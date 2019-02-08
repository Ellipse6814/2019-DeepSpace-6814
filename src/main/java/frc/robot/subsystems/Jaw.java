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
import frc.robot.Enums.JawState;
import frc.robot.Enums.MotorDirection;

public class Jaw extends Subsystem {

    private static Jaw instance;
    public JawState state;

    public static Jaw getInstance() {
        if (instance == null) {
            instance = new Jaw();
        }
        return instance;
    }

    private TalonSRX jawAngleMotor;

    private DigitalInput jawHallEffect = new DigitalInput(Const.kJawHallEffectSensorPort);

    private Jaw() {
        initTalons();
    }

    private void initTalons() {
        jawAngleMotor = new TalonSRX(Const.kJawAngleMotorPort);
        jawAngleMotor.setInverted(false);
        jawAngleMotor.enableVoltageCompensation(true);
        jawAngleMotor.configContinuousCurrentLimit(30, 100);
        jawAngleMotor.configPeakCurrentLimit(0);
    }

    public void setAngle(double angle) {
        // 4096 TalonUnits per rotation
        double targetPositionRotations = Const.getTalon4096Units(angle);
        jawAngleMotor.set(ControlMode.Position, targetPositionRotations);
    }

    public void setOpenLoop(double speed, MotorDirection direction) {
        if (direction == MotorDirection.Forward) {
            jawAngleMotor.set(ControlMode.PercentOutput, speed);
        } else {
            jawAngleMotor.set(ControlMode.PercentOutput, -speed);
        }
    }

    public boolean getHallEffect() {
        return jawHallEffect.get();
    }

    public void resetEncoder() {
        // TODO:
    }

    // public void setJawFront() {
    // setAngle(Const.kJawSetpointDegFront);
    // }

    // public void setJawBack() {
    // setAngle(Const.kJawSetpointDegBack);
    // }

    // public void setJawMiddle() {
    // setAngle(Const.kJawSetpointDegMiddle);
    // }

    // public void setJawCustom(double angle) {
    // setAngle(angle);
    // }

    @Override
    public void initDefaultCommand() {

    }
}
