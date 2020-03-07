/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.models.DriveMode;

public class SetDriveMode extends InstantCommand {
  private DriveMode driveMode = DriveMode.Normal;

  public SetDriveMode(DriveMode driveMode) {
    this.driveMode = driveMode;
  }

  @Override
  public void initialize() {
    Robot.drivetrain.setMode(driveMode);
  }
}
