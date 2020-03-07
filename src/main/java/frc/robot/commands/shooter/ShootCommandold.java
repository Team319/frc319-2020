/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.serializer.SerializeIn;
import frc.robot.commands.tower.TowerUp;

public class ShootCommandold extends CommandBase {
  private double hoodSetpoint;
  private double towerSetpoint;
  private double shooterSetpoint;
  private double serializerSetpoint;

  public ShootCommandold(double hoodSetpoint, double shooterSetpoint, double towerSetpoint, double serializerSetpoint) {

  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    // sets the hood possition, begins the shooter spinning, and starts both the
    // tower and serializer spinning
    new SequentialCommandGroup(new ParallelCommandGroup(new HoodPosition(hoodSetpoint)),
        new SetShooterVelocity(shooterSetpoint),
        new ParallelCommandGroup(new TowerUp(towerSetpoint), new SerializeIn(serializerSetpoint)));
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
