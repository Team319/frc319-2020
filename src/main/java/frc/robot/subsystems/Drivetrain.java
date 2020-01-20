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

public class Drivetrain extends SubsystemBase {

  public static int DRIVE_PROFILE = 0;
  public static int ROTATION_PROFILE = 1;

  public CANSparkMax leftLead = new CANSparkMax(1, MotorType.kBrushless);
  public CANSparkMax rightLead = new CANSparkMax(3, MotorType.kBrushless);

  public CANSparkMax leftFollow = new CANSparkMax(2, MotorType.kBrushless);
  public CANSparkMax rightFollow = new CANSparkMax(4, MotorType.kBrushless);

  public Drivetrain() {

    setupFollowers();

    leftLead.setInverted(true);
    rightLead.setInverted(false);

  }

  private void setupFollowers() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
  }

  public void drive(double left, double right) {
    this.leftLead.set(left);
    this.rightLead.set(right);
  }

  // public void drive(DriveSignal driveSignal) {
  // this.drive(driveSignal.getLeft(), driveSignal.getRight());
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
