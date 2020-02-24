/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.models.BobTalonFX;
import frc.robot.models.DriveMode;
import frc.robot.models.DriveSignal;
import frc.robot.models.PhoenixGains;
import frc.robot.utils.BobDriveHelper;

public class Drivetrain extends SubsystemBase {

  public DriveMode mode = DriveMode.Normal;

  public static int DRIVE_PROFILE = 0;
  public static int ROTATION_PROFILE = 1;

  private PhoenixGains driveGains = new PhoenixGains(DRIVE_PROFILE, 0.0, 0.0, 0.0, 0.0, 0);
  private PhoenixGains rotationGains = new PhoenixGains(ROTATION_PROFILE, 0.0, 0.0, 0.0, 0.0, 0);

  public BobTalonFX leftLead = new BobTalonFX(1);
  public BobTalonFX leftFollow = new BobTalonFX(2);
  public BobTalonFX rightLead = new BobTalonFX(3);
  public BobTalonFX rightFollow = new BobTalonFX(4);

  BobDriveHelper helper;
  private double quickTurnThreshold = 0.2;

  private PIDController limelightRotatePID = new PIDController(0.5, 0.0, 0.0);

  public Drivetrain() {

    helper = new BobDriveHelper();

    limelightRotatePID.setSetpoint(0);

    leftLead.configFactoryDefault();
    rightLead.configFactoryDefault();

    configGains(driveGains);
    configGains(rotationGains);

    leftLead.setInverted(true);
    leftFollow.setInverted(true);
    leftLead.setSensorPhase(true);

    rightLead.setInverted(false);
    rightFollow.setInverted(false);
    rightLead.setSensorPhase(true);
  }

  public void configGains(PhoenixGains gains) {
    this.leftLead.setGains(gains);
    this.rightLead.setGains(gains);
    rightLead.configMaxIntegralAccumulator(ROTATION_PROFILE, 3000);
  }

  public void setMode(DriveMode mode) {
    System.out.println("Setting drivetrain mode to " + mode);
    this.mode = mode;
  }

  private void drive(ControlMode controlMode, double left, double right) {
    this.leftLead.set(controlMode, left);
    this.leftFollow.set(controlMode, left);
    this.rightLead.set(controlMode, right);
    this.rightFollow.set(controlMode, right);
  }

  public void drive(ControlMode controlMode, DriveSignal driveSignal) {
    this.drive(controlMode, driveSignal.getLeft(), driveSignal.getRight());
  }

  @Override
  public void periodic() {
    double rotateValue = 0.0;
    double moveValue = 0.0;
    boolean quickTurn = false;

    moveValue = -Robot.oi.driverController.leftStick.getY();
    quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);

    if (this.mode == DriveMode.Normal) {
      rotateValue = Robot.oi.driverController.rightStick.getX();
    } else if (this.mode == DriveMode.Limelight) {
      rotateValue = -limelightRotatePID.calculate(Robot.limelight.getX());
    }

    DriveSignal driveSignal = helper.cheesyDrive(moveValue, rotateValue, quickTurn, false);

    this.drive(ControlMode.PercentOutput, driveSignal);

    SmartDashboard.putNumber("Rotate Value", rotateValue);
    SmartDashboard.putNumber("Move Value", moveValue);

  }
}
