/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.serializer;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class SerializeOut extends InstantCommand {

  private double serializerSetpoint;

  public SerializeOut(double setpoint) {
    addRequirements(Robot.serializer);
    this.serializerSetpoint = setpoint;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.serializer.set(-serializerSetpoint * 0.5, serializerSetpoint);
  }
}