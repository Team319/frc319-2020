/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Serializer extends SubsystemBase {
  private CANSparkMax serializerLead = new CANSparkMax(11, MotorType.kBrushless);
  private CANSparkMax serializerFollow = new CANSparkMax(12, MotorType.kBrushless);

  /**
   * Creates a new Serializer.
   */
  public Serializer() {
    serializerLead.setInverted(false);
    serializerFollow.setInverted(true);
  }

  @Override
  public void periodic() {
    // double serializerSetpoint = Robot.oi.operatorController.leftStick.getY();
    // this.set(serializerSetpoint);
  }

  public void set(double leftSetpoint, double rightSetpoint) {
    setLeft(leftSetpoint);
    setRight(rightSetpoint);
  }

  public void setLeft(double setpoint) {
    serializerLead.set(setpoint);
  }

  public void setRight(double setpoint) {
    serializerFollow.set(setpoint);
  }
}
