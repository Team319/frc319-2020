/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class ShooterIdle extends CommandBase {
  boolean firstTime;
  double percentage;
  double maxVelocity = -21666;

  /**
   * Creates a new SafelySlowDownShooter.
   */
  public ShooterIdle(double p) {
    addRequirements(Robot.shooter);
    percentage = p;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    firstTime = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((Robot.shooter.getVelocity() >= (maxVelocity * percentage + 100)) && (firstTime)) {
      firstTime = false;
      Robot.shooter.set(ControlMode.Velocity, (maxVelocity * percentage));
    } else if (firstTime) {
      Robot.shooter.set(ControlMode.PercentOutput, 0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
