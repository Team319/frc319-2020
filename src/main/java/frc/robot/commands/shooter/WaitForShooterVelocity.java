/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class WaitForShooterVelocity extends CommandBase {
  private Timer timer = new Timer();
  private double minWaitSeconds = 0.0;
  private double minVelocity = 0.0;
  private double maxWaitSeconds = 0.0;

  public WaitForShooterVelocity(double minVelocity, double minWaitSeconds, double maxWaitSeconds) {
    addRequirements(Robot.shooter);
    this.minWaitSeconds = minWaitSeconds;
    this.minVelocity = minVelocity;
    this.maxWaitSeconds = maxWaitSeconds;
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putNumber("Last Spinup Time", timer.get());
    timer.stop();
  }

  @Override
  public boolean isFinished() {
    double shooterVelocity = Robot.shooter.getVelocity();
    boolean hasAchievedVelocity = shooterVelocity >= minVelocity;
    boolean hasTimeElapsed = timer.get() >= minWaitSeconds;
    boolean cantWaitAnymore = timer.get() >= maxWaitSeconds;
    return (hasTimeElapsed && hasAchievedVelocity) || cantWaitAnymore;
  }
}
