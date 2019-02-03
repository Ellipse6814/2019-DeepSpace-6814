/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Pneumatic;

public class Robot extends TimedRobot {
    public static OI oi = OI.getInstance();
    public static Drive drive = Drive.getInstance();
    public static BallIntake ballIntake = BallIntake.getInstance();
    public static HatchIntake hatchIntake = HatchIntake.getInstance();
    public static Pneumatic pneumatic = Pneumatic.getInstance();
    public static Arm arm = Arm.getInstance();

    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    @Override
    public void robotInit() {
        // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
        // chooser.addOption("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", m_chooser);
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
         * switch(autoSelected) { case "My Auto": autonomousCommand = new
         * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
         * ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }

        System.gc();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
