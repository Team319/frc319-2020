/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class HoodPosition extends CommandBase {

  // private double hoodSetpoint = 0.75;

  public HoodPosition(double setpoint) {
    addRequirements(Robot.shooter);
    // this.hoodSetpoint = setpoint;
  }

  @Override
  public void initialize() {
    // Robot.shooter.setHood(hoodSetpoint);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(final boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
