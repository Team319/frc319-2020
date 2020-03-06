/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class DriveCommand extends InstantCommand {
  double percent;

  /**
   * Creates a new DriveCommand.
   */
  public DriveCommand(double percent) {
    this.percent = percent;
  }

  @Override
  public void initialize() {
    Robot.drivetrain.setDrivetrain(ControlMode.PercentOutput, percent);
  }
}
