/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.GeneralPin;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tower extends SubsystemBase {
  public CANSparkMax towerFront = new CANSparkMax(13, MotorType.kBrushless);
  public CANSparkMax towerBack = new CANSparkMax(14, MotorType.kBrushless);
  public CANifier canifier = new CANifier(0);

  private boolean bottomDetected = false;
  private boolean middleDetected = false;
  private boolean topDetected = false;

  public Tower() {

    this.towerBack.setInverted(true);
    this.towerFront.setInverted(false);
    towerFront.setSmartCurrentLimit(30);
    towerBack.setSmartCurrentLimit(30);
  }

  public void periodic() {
    this.bottomDetected = getBottomBallSensor();
    this.middleDetected = getMiddleBallSensor();
    this.topDetected = getTopBallSensor();
    SmartDashboard.putBoolean("Bottom Ball Sensor", bottomDetected);
    SmartDashboard.putBoolean("Middle Ball Sensor", middleDetected);
    SmartDashboard.putBoolean("Top    Ball Sensor", topDetected);
  }

  public void set(double setpoint) {
    setFront(setpoint);
    setBack(setpoint);
  }

  public void setFront(double setpoint) {
    towerFront.set(-setpoint);
  }

  public void setBack(double setpoint) {
    towerBack.set(-setpoint);
  }

  public boolean getTopBallSensor() {
    return !canifier.getGeneralInput(GeneralPin.LIMF);
  }

  public boolean getMiddleBallSensor() {
    return !canifier.getGeneralInput(GeneralPin.LIMR);
  }

  public boolean getBottomBallSensor() {
    return canifier.getGeneralInput(GeneralPin.QUAD_IDX);
  }

  public boolean isBottomBallDetected() {
    return bottomDetected;
  }

  public boolean isMiddleBallDetected() {
    return middleDetected;
  }

  public boolean isTopBallDetected() {
    return topDetected;
  }

  public void fillTower() {
    double speed = 0.25;
    if (topDetected) {
      setFront(0);
      return;
    }

    if (bottomDetected) {
      setFront(speed);
    }

    if (middleDetected) {
      setFront(speed);
    }

    if (!bottomDetected && !middleDetected) {
      setFront(0);
    }
  }
}
