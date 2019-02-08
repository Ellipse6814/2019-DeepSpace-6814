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
import frc.robot.commands.HatchIntakeClose;
import frc.robot.commands.HatchIntakeOpen;

public class HatchIntake extends Subsystem {

    private static HatchIntake instance;

    public static HatchIntake getInstance() {
        if (instance == null) {
            instance = new HatchIntake();
        }
        return instance;
    }

    private DoubleSolenoid doubleSolenoid;

    private HatchIntake() {
        doubleSolenoid = new DoubleSolenoid(Const.kIntakeSolenoidPort1, Const.kIntakeSolenoidPort2);
    }

    public void openHatchIntake() {
        doubleSolenoid.set(Const.kHatchIntakeOpenPos);
    }

    public void closeHatchIntake() {
        doubleSolenoid.set(Const.kHatchIntakeClosePos);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new HatchIntakeOpen());
    }
}
