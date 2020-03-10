/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.DriveCommand;
import frc.robot.commands.robot.StopShooting;
import frc.robot.commands.shooter.ShootCommand;

public class BasicShootAuto extends SequentialCommandGroup {
  public BasicShootAuto() {
    addCommands(new AutoDriveTime(), new ShootCommand(0.5), new WaitCommand(3), new StopShooting(),
        new DriveCommand(0.15), new AutoDriveTime(), new DriveCommand(0));
  }
}
