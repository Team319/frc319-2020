/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.models.BobTalonSRX;
import frc.robot.models.MotionParameters;
import frc.robot.models.PhoenixGains;

public class Collector extends SubsystemBase {
  private final CANSparkMax collectorLead = new CANSparkMax(8, MotorType.kBrushless);
  private final BobTalonSRX collectorArm = new BobTalonSRX(9);

  private int collectPosition = 0;
  private int homePosition = 0;

  private final PhoenixGains collectorGains = new PhoenixGains(0, 0, 0, 0, 0, 0);
  private final MotionParameters collectorMotionParameters = new MotionParameters(0, 0, collectorGains);

  /**
   * Creates a new Collector.
   */
  public Collector() {

    this.collectorArm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    this.collectorArm.configClosedloopRamp(0.25);
    this.collectorArm.configMotionParameters(collectorMotionParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setCollector(final ControlMode controlMode, final double setpoint) {
    collectorLead.set(setpoint);
  }

  public void setCollectorArm(final ControlMode controlMode, final double setpoint) {
    collectorArm.set(controlMode, setpoint);
  }

  public int getCollectPosition(){
    return collectPosition;
  }

  public int getHomePosition(){
    return homePosition;
  }
}
