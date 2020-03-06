/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.commands.oi.RumbleOperatorController;

public class CollectIn extends InstantCommand {
  private double collectorSetpoint;

  public CollectIn(double setpoint) {
    addRequirements(Robot.collector);
    this.collectorSetpoint = -setpoint;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.collector.setCollector(collectorSetpoint);
    if (collectorSetpoint > 0) {
      Robot.collector.collecting = true;
    } else {
      Robot.collector.collecting = false;
    }
  }
}
