/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private TalonFX shooterLead = new TalonFX(5);
  private TalonFX shooterFollow = new TalonFX(6);

  private DoubleSolenoid hoodSolenoid = new DoubleSolenoid(2, 3);

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    this.shooterFollow.follow(shooterLead);
    this.shooterFollow.setInverted(InvertType.OpposeMaster);
  }

  public void set(ControlMode controlMode, double setpoint) {
    shooterLead.set(controlMode, setpoint);
  }

  public void hoodExtend() {
    this.hoodSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void hoodRetract() {
    this.hoodSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
