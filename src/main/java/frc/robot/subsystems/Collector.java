/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
  private CANSparkMax collectorLead = new CANSparkMax(8, MotorType.kBrushless);
  private TalonSRX collectorArm = new TalonSRX(9);
  /**
   * Creates a new Collector.
   */
  public Collector() {
  
  }


@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setCollector(ControlMode controlMode, double setpoint) {
    collectorLead.set(setpoint);
  }

  public void setCollectorArm(ControlMode controlMode, double setpoint) {
    collectorArm.set(controlMode, setpoint);
  }
}
