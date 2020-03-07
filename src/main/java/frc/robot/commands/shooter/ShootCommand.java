/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.pneumatics.DisableCompressor;
import frc.robot.commands.robot.FeedShooter;

public class ShootCommand extends SequentialCommandGroup {
  public ShootCommand(double shooterSetpoint) {
    addCommands(new DisableCompressor(), new SetShooterVelocity(shooterSetpoint),
        new WaitForShooterVelocity(shooterSetpoint, 0.0, 1.0), new FeedShooter());
  }
}
