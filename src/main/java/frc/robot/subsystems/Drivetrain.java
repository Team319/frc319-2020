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
import frc.robot.models.PidGains;
import frc.robot.utils.BobDriveHelper;
import frc.robot.utils.HelperFunctions;

public class Drivetrain extends SubsystemBase {

  public DriveMode mode = DriveMode.Normal;

  public static int DRIVE_PROFILE = 0;
  public static int ROTATION_PROFILE = 1;

  private PidGains driveGains = new PidGains(DRIVE_PROFILE, 0.0, 0.0, 0.0, 0.0, 0);
  private PidGains rotationGains = new PidGains(ROTATION_PROFILE, 0.0, 0.0, 0.0, 0.0, 0);

  public BobTalonFX leftLead = new BobTalonFX(1);
  public BobTalonFX leftFollow = new BobTalonFX(2);
  public BobTalonFX rightLead = new BobTalonFX(3);
  public BobTalonFX rightFollow = new BobTalonFX(4);

  BobDriveHelper helper;
  private double quickTurnThreshold = 0.2;

  private PIDController limelightRotatePID = new PIDController(1.0, 0.0, 0.01);

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

    leftLead.configOpenloopRamp(0.25);
    leftFollow.configOpenloopRamp(0.25);
    rightLead.configOpenloopRamp(0.25);
    rightFollow.configOpenloopRamp(0.25);
  }

  public void configGains(PidGains gains) {
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
  }

  public void teleopDrive() {
    double rotateValue = 0.0;
    double moveValue = 0.0;
    double turnMultiplier = 0.5;
    boolean quickTurn = false;

    moveValue = -Robot.oi.driverController.leftStick.getY();
    quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);

    if (this.mode == DriveMode.Normal) {
      rotateValue = Robot.oi.driverController.rightStick.getX();
      rotateValue = HelperFunctions.signedSquare(rotateValue) * turnMultiplier;
    } else if (this.mode == DriveMode.Limelight) {
      rotateValue = -limelightRotatePID.calculate(Robot.limelight.getXProportional());
      rotateValue = HelperFunctions.limit(rotateValue, -0.25, 0.25);
    }

    DriveSignal driveSignal = helper.cheesyDrive(moveValue, rotateValue, quickTurn, false);

    this.drive(ControlMode.PercentOutput, driveSignal);

    SmartDashboard.putNumber("Rotate Value", rotateValue);
    SmartDashboard.putNumber("Move Value", moveValue);
  }

  public void setDrivetrain(ControlMode controlMode, Double percentOutput) {
    this.leftLead.set(controlMode, percentOutput);
    this.leftFollow.set(controlMode, percentOutput);
    this.rightLead.set(controlMode, percentOutput);
    this.rightFollow.set(controlMode, percentOutput);

  }

  public double getDistance() {
    return rightLead.getSelectedSensorPosition();
  }
}
