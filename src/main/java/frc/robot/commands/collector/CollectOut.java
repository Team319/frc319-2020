/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class CollectOut extends CommandBase {
  private double collectorSetpoint;

  public CollectOut(double setpoint) {
    addRequirements(Robot.collector);
    this.collectorSetpoint = setpoint;
  }

  @Override
  public void initialize() {
    Robot.collector.setCollector(collectorSetpoint);
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
