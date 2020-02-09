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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.models.BobTalonFX;
import frc.robot.models.MotionParameters;
import frc.robot.models.PhoenixGains;

public class Shooter extends SubsystemBase {
  private BobTalonFX shooterLead = new BobTalonFX(7);
  private BobTalonFX shooterFollow = new BobTalonFX(6);
  private CANSparkMax hoodMotor = new CANSparkMax(5, MotorType.kBrushless);

  private final PhoenixGains shooterGains = new PhoenixGains(0, 0.05, 0.001, 0.7, 0.0472, 150);
  private MotionParameters shooterMotionParameters = new MotionParameters(0, 0, shooterGains);

  private DoubleSolenoid hoodSolenoid = new DoubleSolenoid(0, 1);

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

  public double getVelocity() {
    double currentVelocity = this.shooterLead.getSelectedSensorVelocity();
    return currentVelocity;
  }

  public double getPosition() {
    double currentPosition = this.shooterLead.getSelectedSensorPosition();
    return currentPosition;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Velocity", this.getVelocity());
    SmartDashboard.putNumber("Shooter Velocity Text", this.getVelocity());
  }

  public void set(ControlMode controlMode, double setpoint) {
    shooterLead.set(controlMode, setpoint);
  }

  public void setHood(final ControlMode controlMode, final double setpoint) {
    hoodMotor.set(setpoint);
  }
}
