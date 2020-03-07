/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.models.RobotMode;

public class SetRobotMode extends CommandBase {
  private RobotMode robotMode = RobotMode.Normal;

  public SetRobotMode(RobotMode robotMode) {
    this.robotMode = robotMode;
  }

  @Override
  public void initialize() {
    Robot.robotMode = this.robotMode;
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
