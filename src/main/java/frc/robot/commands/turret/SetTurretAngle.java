/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class SetTurretAngle extends InstantCommand {
  private double setpoint;

  public SetTurretAngle(double degrees) {
    this.setpoint = degrees;
  }

  @Override
  public void initialize() {
    Robot.turret.setAngle(setpoint);
  }
}
