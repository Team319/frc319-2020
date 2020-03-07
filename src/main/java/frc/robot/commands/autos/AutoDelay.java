/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoDelay extends CommandBase {
  private double delaySeconds = 0;
  private Timer timer = new Timer();

  public AutoDelay() {
  }

  @Override
  public void initialize() {
    delaySeconds = SmartDashboard.getNumber("Auto Delay", 0);
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    boolean hasTimeElapsed = timer.get() >= delaySeconds;
    return hasTimeElapsed;
  }
}
