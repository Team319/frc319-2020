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

public class Tower extends SubsystemBase {
  public CANSparkMax towerLead = new CANSparkMax(13, MotorType.kBrushless);
  public CANSparkMax towerFollow = new CANSparkMax(14, MotorType.kBrushless);

  public Tower() {

    this.towerFollow.setInverted(true);
    this.towerLead.setInverted(false);

  }

  public void periodic() {
    // double towerSetpoint = Robot.oi.operatorController.leftStick.getY();
    // this.set(towerSetpoint);
  }

  public void set(double setpoint) {
    // double rumble = Math.abs(setpoint);
    // Robot.oi.driverController.setRumble(rumble, rumble);
    // Robot.oi.operatorController.setRumble(rumble, rumble);
    towerLead.set(-setpoint);
    towerFollow.set(-setpoint);

  }
}
