/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.models.DriveSignal;
import frc.robot.utils.BobDriveHelper;

public class Drivetrain extends SubsystemBase {

  public static int DRIVE_PROFILE = 0;
  public static int ROTATION_PROFILE = 1;

  public CANSparkMax leftLead = new CANSparkMax(1, MotorType.kBrushless);
  public CANSparkMax rightLead = new CANSparkMax(3, MotorType.kBrushless);

  public CANSparkMax leftFollow = new CANSparkMax(2, MotorType.kBrushless);
  public CANSparkMax rightFollow = new CANSparkMax(4, MotorType.kBrushless);

  BobDriveHelper helper;
  private double quickTurnThreshold = 0.2;

  public Drivetrain() {
    helper = new BobDriveHelper();

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

  public void drive(ControlMode controlMode, DriveSignal driveSignal) {
    this.drive(controlMode, driveSignal.getLeft(), driveSignal.getRight());
  }

  private void drive(ControlMode controlMode, double left, double right) {
  }

  @Override
  public void periodic() {
    double rotateValue = Robot.oi.driverController.rightStick.getX();

    double moveValue = -Robot.oi.driverController.leftStick.getY();
    boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
    DriveSignal driveSignal = helper.cheesyDrive(moveValue, rotateValue, quickTurn, false);
    this.drive(ControlMode.PercentOutput, driveSignal);
  }
}
