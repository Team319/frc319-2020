/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class SpinShooter extends InstantCommand {
  private ControlMode controlMode = ControlMode.PercentOutput;

  private double shooterSetpoint;

  public SpinShooter(ControlMode controlMode, double setpoint) {
    addRequirements(Robot.shooter);
    this.shooterSetpoint = setpoint;
    this.controlMode = controlMode;
  }

  @Override
  public void initialize() {
    Robot.shooter.set(controlMode, shooterSetpoint);
  }
}
