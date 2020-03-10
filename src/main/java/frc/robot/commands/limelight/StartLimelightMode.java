/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.robot.SetRobotMode;
import frc.robot.models.RobotMode;

public class StartLimelightMode extends ParallelCommandGroup {
  public StartLimelightMode() {
    addCommands(new SetRobotMode(RobotMode.Limelight), new TurnLedsOn());
  }
}
