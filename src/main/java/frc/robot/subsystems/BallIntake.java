/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;

public class BallIntake extends Subsystem {

    private static BallIntake instance;

    public static BallIntake getInstance() {
        if (instance == null) {
            instance = new BallIntake();
        }
        return instance;
    }

    private TalonSRX rollerMotor;

    private BallIntake() {
        initTalons();
    }

    private void initTalons() {
        rollerMotor = new TalonSRX(Const.kIntakeRollerMotorPort);
        rollerMotor.setInverted(false);
        rollerMotor.enableVoltageCompensation(true);
        rollerMotor.configContinuousCurrentLimit(5, 100);
        rollerMotor.configPeakCurrentLimit(0);
    }

    public void setRollerIn() {
        // TODO:
    }

    public void setRollerOut() {
        // TODO:
    }

    public void setRollerHold() {
        // TODO:
    }

    public void setRollerStop() {
        // TODO:
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
