/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.models.BobTalonFX;
import frc.robot.models.MotionParameters;
import frc.robot.models.PidGains;

public class Shooter extends SubsystemBase {
  double currentVelocity;
  double maxVelocity = -21666;
  // private CANSparkMax hoodMotor = new CANSparkMax(5, MotorType.kBrushless);
  private BobTalonFX shooterLead = new BobTalonFX(6);
  private BobTalonFX shooterFollow = new BobTalonFX(7);

  private final PidGains shooterGains = new PidGains(0, 0.05, 0.001, 0.7, 0.0504, 150);
  private MotionParameters shooterMotionParameters = new MotionParameters(0, 0, shooterGains);

  /**
   * Creates a new Shooter.
   */
  public Shooter() {

    this.shooterLead.setInverted(true);
    this.shooterFollow.setInverted(false);

    this.shooterLead.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    this.shooterLead.configClosedloopRamp(0.25);
    this.shooterLead.configMotionParameters(shooterMotionParameters);
  }

  public double getVelocity() {
    return this.shooterLead.getSelectedSensorVelocity() / maxVelocity;

  }

  public double getPosition() {
    return this.shooterLead.getSelectedSensorPosition();
  }

  public double getCurrentDraw() {
    return this.shooterLead.getSupplyCurrent();
  }

  public double getVoltageOutput() {
    return this.shooterLead.getMotorOutputVoltage();
  }

  @Override
  public void periodic() {
    // SmartDashboard.putNumber("Shooter Velocity", Math.abs(this.getVelocity()));
    // SmartDashboard.putNumber("Shooter Velocity Text",
    // Math.abs(this.getVelocity()));
    // SmartDashboard.putNumber("Current Draw", this.getCurrentDraw());
    // SmartDashboard.putNumber("Voltage Output",
    // Math.abs(this.getVoltageOutput()));
  }

  public void set(ControlMode controlMode, double setpoint) {
    shooterLead.set(controlMode, setpoint);
    shooterFollow.set(controlMode, setpoint);
  }

  public void setPercentVelocity(double percentVelocity) {
    this.set(ControlMode.Velocity, this.maxVelocity * percentVelocity);
  }

  // public void setHood(double setpoint) {
  // hoodMotor.set(setpoint);
  // }

}
