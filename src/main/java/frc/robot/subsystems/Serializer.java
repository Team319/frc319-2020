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
  private CANSparkMax serializerLead = new CANSparkMax(14, MotorType.kBrushless);
  private CANSparkMax serializerFollow = new CANSparkMax(15, MotorType.kBrushless);

  /**
   * Creates a new Serializer.
   */
  public Serializer() {
    serializerLead.setInverted(false);
    serializerFollow.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double setpoint) {
    serializerLead.set(setpoint);
    serializerFollow.set(setpoint);
  }

}
