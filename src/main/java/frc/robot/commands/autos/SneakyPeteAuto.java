/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.paths.SneakyPetePart2;
import frc.robot.commands.FollowPath;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.collector.CollectorStartCollect;
import frc.robot.commands.shooter.ShootCommand;
import frc.robot.paths.SneakyPete;

public class SneakyPeteAuto extends SequentialCommandGroup {
  public SneakyPeteAuto() {
    addCommands(new CollectorStartCollect(), new FollowPath(new SneakyPete()), new CollectIn(0),
        new FollowPath(new SneakyPetePart2()), new ShootCommand(0));
  }
}
