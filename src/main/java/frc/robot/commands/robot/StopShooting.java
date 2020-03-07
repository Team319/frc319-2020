/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.pneumatics.EnableCompressor;
import frc.robot.commands.serializer.SerializeIn;
import frc.robot.commands.shooter.SpinShooter;
import frc.robot.commands.tower.TowerUp;

public class StopShooting extends ParallelCommandGroup {
  public StopShooting() {
    addCommands(new SpinShooter(ControlMode.PercentOutput, 0), new CollectIn(0), new SerializeIn(0), new TowerUp(0),
        new EnableCompressor());
  }
}
