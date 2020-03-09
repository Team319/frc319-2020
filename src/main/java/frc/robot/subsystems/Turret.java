/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.models.BobSparkMaxBrushless;
import frc.robot.models.MotionParameters;
import frc.robot.models.PidGains;
import frc.robot.models.RobotMode;
import frc.robot.utils.HelperFunctions;

public class Turret extends SubsystemBase {

  private BobSparkMaxBrushless turretLead = new BobSparkMaxBrushless(16);
  private PidGains gains = new PidGains(0, 0.00001, 0.0, 0.0002, 0.000156, 0);
  private MotionParameters motionParameters = new MotionParameters(15000, 11000, gains);
  private final double ratio = 200;
  private final double maxAngle = 45.0;
  private final double startingAngle = 54.0;
  private final double limelightOffset = -3;
  private double lastLimelightAngle = 0;
  double degreesOff;

  public Turret() {
    turretLead.configMotionParameters(motionParameters);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Turret Postition", getAngle());

    if (Robot.robotMode == RobotMode.Limelight) {
      setAngle(getAngle() + Robot.limelight.getX());
      SmartDashboard.putNumber("Limelight x", Robot.limelight.getX());
    }
  }

  public void limelightSet() {
    degreesOff = Robot.limelight.getX();
  }

  public void set(double setpoint) {
    turretLead.set(setpoint);
  }

  public void setAngle(double degrees) {
    double cappedAngle = HelperFunctions.limit(degrees, maxAngle);
    double setpoint = degreesToNeoPosition(startingAngle + cappedAngle + limelightOffset);
    turretLead.set(setpoint, ControlType.kSmartMotion);

  }

  public void resetPosition(double degrees) {
    turretLead.setPosition(degreesToNeoPosition(degrees));
  }

  public void setVelocity(double setpoint) {
    turretLead.set(setpoint, ControlType.kVelocity);
  }

  public void setPercentOutput(double setpoint) {
    turretLead.set(setpoint);
  }

  public double getRawPosition() {
    return turretLead.getPosition();
  }

  public double getAngle() {
    return neoPositionToDegrees(getRawPosition()) - startingAngle;
  }

  public double degreesToNeoPosition(double degrees) {
    return (degrees / 360) * ratio;
  }

  public double neoPositionToDegrees(double neoPosition) {
    return (neoPosition / ratio) * 360;
  }

}