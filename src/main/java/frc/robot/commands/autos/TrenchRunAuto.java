/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.paths.TrenchRunEpisodeI;
import frc.paths.TrenchRunEpisodeII;
import frc.robot.commands.FollowPath;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.collector.CollectorStartCollect;
import frc.robot.commands.robot.StopShooting;
import frc.robot.commands.shooter.ShootCommand;

public class TrenchRunAuto extends SequentialCommandGroup {
    public TrenchRunAuto() {
        addCommands(new ShootAndDontMove(), new CollectorStartCollect(), new FollowPath(new TrenchRunEpisodeI()),
                new CollectIn(0), new FollowPath(new TrenchRunEpisodeII()), new ShootCommand(0.53), new WaitCommand(3),
                new StopShooting());
    }
}
