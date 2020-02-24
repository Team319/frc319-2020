/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Climber extends SubsystemBase {
  double climberIncriment = 100;
  double climberBottom = 0;

  public CANSparkMax climberLead = new CANSparkMax(8, MotorType.kBrushless);
  public CANSparkMax climberFollow = new CANSparkMax(9, MotorType.kBrushless);

  // public DoubleSolenoid climberSolenoid = new DoubleSolenoid(4, 5);

  /**
   * Creates a new Climber.
   */
  public Climber() {
    this.climberFollow.setInverted(true);
    this.climberLead.setInverted(false);

    this.climberFollow.setIdleMode(IdleMode.kBrake);
    this.climberLead.setIdleMode(IdleMode.kBrake);

    this.climberLead.setOpenLoopRampRate(0.25);
    this.climberFollow.setOpenLoopRampRate(0.25);
  }

  public void climberExtend() {
    // this.climberSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void climberRetract() {
    // this.climberSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    /*
     * double input = (Robot.oi.operatorController.rightStick.getY()); double
     * climbersetpoint = (getCurrentPosition() + (input * climberIncriment)); if
     * (climbersetpoint >= climberBottom && input <= 0) {
     * this.setClimber(climbersetpoint); } else { new DoNothing(); }
     */
    double input = -Robot.oi.operatorController.rightStick.getY();
    if (input <= 0) {
      this.setClimber(input * 0.75);
      SmartDashboard.putNumber("Climber Lead Current:", this.climberLead.getOutputCurrent());
      SmartDashboard.putNumber("Climber Follow Current:", this.climberFollow.getOutputCurrent());
    } else {
      this.setClimber(input * 0.5);
    }
  }

  public void setClimber(double setpoint) {
    climberLead.set(setpoint);
    climberFollow.set(setpoint);
  }
  // This method will be called once per scheduler run

}
