/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.robot.SetRobotMode;
import frc.robot.commands.turret.SetTurretAngle;
import frc.robot.models.RobotMode;

public class StopLimelightMode extends ParallelCommandGroup {
  public StopLimelightMode() {
    addCommands(new SetRobotMode(RobotMode.Normal), new TurnLedsOff(), new SetTurretAngle(0));
  }
}
