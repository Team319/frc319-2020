/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.serializer.SerializeIn;
import frc.robot.commands.tower.TowerUp;

public class Preload extends ParallelCommandGroup {
  public Preload() {
    addCommands(new SerializeIn(1), new TowerUp(0.25));
  }
}
