/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Enums.MotorDirection;

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

        // rollerMotor.configPeakCurrentDuration(100, 10); // 100ms /
        rollerMotor.configPeakCurrentDuration(0, Const.kTalonCommTimeout); // don't allow peak
        rollerMotor.configContinuousCurrentLimit(5, Const.kTalonCommTimeout); // 30A /
        rollerMotor.enableCurrentLimit(true); // turn it on
    }

    public void setMaxAmp(int maxAmp) {
        rollerMotor.configContinuousCurrentLimit(5, Const.kTalonCommTimeout); // 30A /
    }

    /**
     * ALWAYS CALL {@link setMaxAmp}
     * 
     * @param direction
     */
    public void setMotor(MotorDirection direction, double amps) {
        if (amps < 0.001)
            rollerMotor.set(ControlMode.PercentOutput, 0);
        rollerMotor.set(ControlMode.Current, amps);
    }

    // public void setRollerIn() {
    // // TODO:
    // }

    // public void setRollerOut() {
    // // TODO:
    // }

    // public void setRollerHold() {
    // // TODO:
    // }

    // public void setRollerStop() {
    // // TODO:
    // }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
