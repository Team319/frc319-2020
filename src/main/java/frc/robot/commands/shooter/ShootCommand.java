/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.oi.RumbleDriverController;
import frc.robot.commands.oi.RumbleOperatorController;
import frc.robot.commands.pneumatics.DisableCompressor;
import frc.robot.commands.robot.FeedShooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootCommand extends SequentialCommandGroup {
  /**
   * Creates a new ShootCommand.
   */
  public ShootCommand(double shooterSetpoint) {
    addCommands(new DisableCompressor(), new SetShooterVelocity(shooterSetpoint),
        new WaitForShooterVelocity(shooterSetpoint, 0.0, 1.0), new FeedShooter());
  }
}
