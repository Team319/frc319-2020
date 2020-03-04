/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.tower;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class TowerUp extends InstantCommand {

  private double towerSetpoint;

  public TowerUp(double setpoint) {
    addRequirements(Robot.tower);
    this.towerSetpoint = -setpoint;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.tower.set(towerSetpoint);
  }
}
