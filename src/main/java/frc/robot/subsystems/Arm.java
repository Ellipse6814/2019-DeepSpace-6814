/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;

public class Arm extends Subsystem {

    private static Arm instance;

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private TalonSRX jawAngleMotor;

    private DigitalInput jawHallEffect = new DigitalInput(Const.kJawHallEffectSensorPort);
    private DigitalInput armHallEffectFront = new DigitalInput(Const.kArmHallEffectFrontSensorPort);
    private DigitalInput armHallEffectBack = new DigitalInput(Const.kArmHallEffectBackSensorPort);

    private TalonSRX armMotor;
    private VictorSPX armMotorSlave;

    private Arm() {
        initTalons();
    }

    private void initTalons() {
        jawAngleMotor = new TalonSRX(Const.kJawAngleMotorPort);
        jawAngleMotor.setInverted(false);
        jawAngleMotor.enableVoltageCompensation(true);
        jawAngleMotor.configContinuousCurrentLimit(30, 100);
        jawAngleMotor.configPeakCurrentLimit(0);

        armMotor = new TalonSRX(Const.kArmMotorPort);
        armMotor.setInverted(false);
        armMotor.enableVoltageCompensation(true);
        armMotor.configContinuousCurrentLimit(30, 100);
        armMotor.configPeakCurrentLimit(0);

        armMotorSlave = new VictorSPX(Const.kArmMotorSlavePort);
        armMotorSlave.follow(armMotor);
        armMotorSlave.setInverted(InvertType.FollowMaster);
        armMotorSlave.enableVoltageCompensation(true);
    }

    public void setJawAngle(double angle) {
        // TODO: set talon pid value
    }

    public void setJawFront() {
        setJawAngle(-25535); // TODO:
    }

    public void setJawBack() {
        setJawAngle(-25535); // TODO:
    }

    public void setJawMiddle() {
        setJawAngle(-25535); // TODO:
    }

    public void setArmAngle(double angle) {
        // TODO: set talon pid value
    }

    public void setArmFront() {
        setArmAngle(-25535); // TODO:
    }

    public void setArmBack() {
        setArmAngle(-25535); // TODO:
    }

    public void setArmMiddle() {
        setArmAngle(-25535); // TODO:
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
