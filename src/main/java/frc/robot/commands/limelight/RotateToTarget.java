/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
/*
 * package frc.robot.commands.limelight;
 * 
 * import edu.wpi.first.wpilibj2.command.PIDCommand; import frc.robot.Robot;
 * 
 * public class RotateToTarget extends PIDCommand {
 * 
 * public RotateToTarget(double kP, double kI, double kD) { super(kP, kI, kD); }
 * 
 * @Override public void setSetpoint(double setpoint) {
 * super.setSetpoint(setpoint); }
 * 
 * // Called just before this Command runs the first time
 * 
 * @Override protected void initialize() { }
 * 
 * // Called repeatedly when this Command is scheduled to run
 * 
 * @Override protected void execute() { }
 * 
 * // Make this return true when this Command no longer needs to run execute()
 * 
 * @Override protected boolean isFinished() { if ((this.getPosition() <=
 * this.getSetpoint() + 0.1) && (this.getPosition() >= this.getSetpoint() -
 * 0.1)) { return true; } return false; }
 * 
 * // Called once after isFinished returns true
 * 
 * @Override protected void end() { // Robot.limelight.stopRobot(); }
 * 
 * // Called when another command which requires one or more of the same //
 * subsystems is scheduled to run
 * 
 * @Override protected void interrupted() { }
 * 
 * @Override protected double returnPIDInput() {
 * System.out.println("Limelight X " + Robot.limelight.getX()); return
 * Robot.limelight.getX(); }
 * 
 * @Override protected void usePIDOutput(double output) { //
 * System.out.println("PID Output " + -output);
 * Robot.limelight.trackPIDR(-output); } }
 */