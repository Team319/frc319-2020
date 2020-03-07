/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.models.BobSparkMaxBrushless;
import frc.robot.models.MotionParameters;
import frc.robot.models.PidGains;

public class Turret extends SubsystemBase {

  private BobSparkMaxBrushless turretLead = new BobSparkMaxBrushless(16);
  private PidGains gains = new PidGains(0, 5e-5, 1e-6, 0, 0.000156, 0);
  private MotionParameters motionParameters = new MotionParameters(1500, 2000, gains);
  double setpoint;
  double degreesOff;

  /**
   * Creates a new Turret.
   */
  public Turret() {
    turretLead.configMotionParameters(motionParameters);
  }

  @Override
  public void periodic() {
  }

  public void limelightSet() {
    degreesOff = Robot.limelight.getX();
  }

  public void set(double setpoint) {
    turretLead.set(setpoint);
  }

  public void setAngle(double degrees) {
    // probably going to have to do some conversion to get from
    // degrees to whatever the spark max wants.
    turretLead.set(setpoint, ControlType.kSmartMotion);

  }

  public void setVelocity(double setpoint) {
    turretLead.set(setpoint, ControlType.kVelocity);
  }

  public void setPercentOutput(double setpoint) {
    turretLead.set(setpoint);
  }

}