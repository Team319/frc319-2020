/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class VelocityTurret extends CommandBase {
  private double setpoint;

  public VelocityTurret(double velocity) {
    addRequirements(Robot.turret);
    this.setpoint = velocity;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.turret.setVelocity(setpoint);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
