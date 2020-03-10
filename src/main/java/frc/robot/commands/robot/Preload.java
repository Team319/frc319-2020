/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.serializer.SerializeIn;
import frc.robot.commands.tower.FillTower;

public class Preload extends ParallelCommandGroup {
  public Preload() {
    addCommands(new SerializeIn(1), new FillTower());
  }
}
/*
 * case 0 no balls do nothing case 1 lower sensor detecting both in case 2
 * middle sensor detecting stop case 3 lower and middle both in case 4 top
 * sensor stop case 5 top sensor and lower forward in back out case 6 top sensor
 * and middle stop case 7 all three stop
 */