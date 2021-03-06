/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.serializer.SerializeOut;

public class Unjam extends ParallelRaceGroup {
  public Unjam() {
    addCommands(new CollectIn(0.5), new SerializeOut(0.5));
  }
}
