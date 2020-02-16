/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.models.BobTalonFX;
import frc.robot.models.DriveSignal;
import frc.robot.models.LeaderBobTalonFX;
import frc.robot.models.PhoenixGains;
import frc.robot.utils.BobDriveHelper;

public class Drivetrain extends SubsystemBase {

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

  public Drivetrain() {

    helper = new BobDriveHelper();

    leftLead.configFactoryDefault();
    rightLead.configFactoryDefault();
    
    configGains(driveGains);
		configGains(rotationGains);

    leftLead.setInverted(false);
    leftFollow.setInverted(false);
    leftLead.setSensorPhase(true);
    rightLead.setInverted(true);
    rightFollow.setInverted(true);
    rightLead.setSensorPhase(true);
  }

	public void configGains(PhoenixGains gains) {
		this.leftLead.setGains(gains);
		this.rightLead.setGains(gains);
		rightLead.configMaxIntegralAccumulator(ROTATION_PROFILE, 3000);
	}


  public void drive(double left, double right) {
    // this.leftLead.set(left);
    // this.rightLead.set(right);
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
    double rotateValue = Robot.oi.driverController.rightStick.getX();

    double moveValue = -Robot.oi.driverController.leftStick.getY();
    boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
    DriveSignal driveSignal = helper.cheesyDrive(moveValue, rotateValue, quickTurn, false);
    this.drive(ControlMode.PercentOutput, driveSignal);

    SmartDashboard.putNumber("Rotate Value", rotateValue);
    SmartDashboard.putNumber("Move Value", moveValue);
  }
}
