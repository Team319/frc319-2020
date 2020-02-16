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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

  // public CANSparkMax climberLead = new CANSparkMax(13, MotorType.kBrushless);
  // public CANSparkMax climberFollow = new CANSparkMax(14, MotorType.kBrushless);

  // public DoubleSolenoid climberSolenoid = new DoubleSolenoid(4, 5);

  /**
   * Creates a new Climber.
   */
  public Climber() {

    this.climberFollow.setInverted(true);
    this.climberLead.setInverted(false);


  }

  public void climberExtend() {
    // this.climberSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void climberRetract() {
    // this.climberSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
