/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.paths.DriveForwardFiveFeetPath;
import frc.robot.commands.FollowPath;

public class DriveForwardFiveFeet extends SequentialCommandGroup {
  public DriveForwardFiveFeet() {
    addCommands(new FollowPath(new DriveForwardFiveFeetPath()));
  }
}
