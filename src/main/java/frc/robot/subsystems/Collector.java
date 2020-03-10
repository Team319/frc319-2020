/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Collector extends SubsystemBase {
  public boolean collecting = false;
  private CANSparkMax collectorLead = new CANSparkMax(10, MotorType.kBrushless);
  private CANSparkMax collectorFollow = new CANSparkMax(15, MotorType.kBrushless);
  private DoubleSolenoid collectorSolenoid = new DoubleSolenoid(1, 0, 1);

  public Collector() {
    collectorLead.setSmartCurrentLimit(25);
    collectorLead.setSmartCurrentLimit(25);
    collectorFollow.setInverted(true);
    collectorLead.setInverted(false);
  }

  public void collectorExtend() {
    System.out.println("Collector ");
    this.collectorSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void collectorRetract() {
    this.collectorSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Collecting", collecting);
  }

  public void setCollector(double setpoint) {
    double rumble = Math.abs(setpoint);
    Robot.oi.driverController.setRumble(rumble, rumble);
    Robot.oi.operatorController.setRumble(rumble, rumble);
    collectorLead.set(setpoint);
    collectorFollow.set(setpoint);
  }
}
