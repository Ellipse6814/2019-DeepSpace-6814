/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Const;
import frc.robot.Enums.ArmState;
import frc.robot.Enums.JawState;
import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.BallIntakeSet;
import frc.robot.commands.JawSetAngle;

public class IntakeHatchFront extends CommandGroup {
  /**
   * Add your docs here.
   */
  public IntakeHatchFront() {
    addParallel(new ArmSetAngle(ArmState.FrontHatchInOut));
    addParallel(new JawSetAngle(JawState.Front));
    addParallel(new BallIntakeSet(Const.kBallIntakeInAmp)); // todo
  }
}
