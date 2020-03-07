/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.drivetrain.SetDriveMode;
import frc.robot.models.DriveMode;

public class StopLimelightMode extends ParallelCommandGroup {
  public StopLimelightMode() {
    addCommands(new SetDriveMode(DriveMode.Normal), new TurnLedsOff());
  }
}
