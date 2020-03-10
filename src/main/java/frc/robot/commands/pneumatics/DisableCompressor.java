/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class DisableCompressor extends InstantCommand {
  public DisableCompressor() {
    addRequirements(Robot.pneumatics);
  }

  @Override
  public void initialize() {
    Robot.pneumatics.disableCompressor();
  }
}
