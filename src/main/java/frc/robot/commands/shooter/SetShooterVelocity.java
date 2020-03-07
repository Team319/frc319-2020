/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class SetShooterVelocity extends InstantCommand {
  double percentage;

  public SetShooterVelocity(double p) {
    addRequirements(Robot.shooter);

    percentage = p;
  }

  @Override
  public void initialize() {
    Robot.shooter.setPercentVelocity(percentage);
  }
}
