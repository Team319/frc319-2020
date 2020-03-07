/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.oi.RumbleDriverController;
import frc.robot.commands.oi.RumbleOperatorController;

public class CollectorStopCollect extends SequentialCommandGroup {
  public CollectorStopCollect() {
    addCommands(new RumbleDriverController(0.0), new RumbleOperatorController(0.0), new CollectIn(0),
        new CollectorRetract());
  }
}
