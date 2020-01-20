/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.models.BobTalonFX;
import frc.robot.models.FXGains;
import frc.robot.models.MotionParameters;

public class Shooter extends SubsystemBase {
  private BobTalonFX shooterLead = new BobTalonFX(5);
  private BobTalonFX shooterFollow = new BobTalonFX(6);

  private final FXGains shooterGains = new FXGains(0, 0, 0, 0, 0, 0);
  private MotionParameters shooterMotionParameters = new MotionParameters(0, 0, shooterGains);

  /**
   * Creates a new Shooter.
   */
  public Shooter() {

    this.shooterFollow.follow(shooterLead);
    this.shooterFollow.setInverted(InvertType.OpposeMaster);
    this.shooterLead.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    this.shooterLead.configClosedloopRamp(0.25);
    this.shooterLead.configMotionParameters(shooterMotionParameters);
  }

  public double getShooterVelocity() {
    double currentVelocity = this.shooterLead.getSelectedSensorVelocity();
    return currentVelocity;
  }

  public double getShooterPossition() {
    double currentPossition = this.shooterLead.getSelectedSensorPosition();
    return currentPossition;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Velocity", this.getShooterVelocity() / 2048 * 600);
    SmartDashboard.putNumber("Shooter Possition", this.getShooterPossition());
  }

  public void set(ControlMode controlMode, double setpoint) {
    shooterLead.set(controlMode, setpoint);
  }

}
