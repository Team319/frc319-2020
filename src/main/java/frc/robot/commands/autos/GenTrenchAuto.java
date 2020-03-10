/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.paths.GenTrenchPArt2;
import frc.paths.GenTrenchPart1;
import frc.robot.commands.FollowPath;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.collector.CollectorStartCollect;
import frc.robot.commands.shooter.ShootCommand;

public class GenTrenchAuto extends SequentialCommandGroup {
  public GenTrenchAuto() {
    addCommands(new ShootAndDontMove(), new CollectorStartCollect(), new FollowPath(new GenTrenchPart1()),
        new CollectIn(0), new FollowPath(new GenTrenchPArt2()), new ShootCommand(0.53));
  }
}
