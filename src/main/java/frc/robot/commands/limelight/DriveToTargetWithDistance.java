/*
 * package frc.robot.commands.limelight;
 * 
 * import edu.wpi.first.wpilibj2.command.PIDCommand; import frc.robot.Robot;
 * 
 * public class DriveToTargetWithDistance extends PIDCommand {
 * 
 * public DriveToTargetWithDistance(double kP, double kI, double kD) { super(kP,
 * kI, kD); }
 * 
 * @Override public void setSetpoint(double setpoint) {
 * super.setSetpoint(setpoint); }
 * 
 * @Override protected void initialize() { }
 * 
 * @Override protected void execute() { }
 * 
 * @Override protected boolean isFinished() { if ((this.getPosition() <=
 * this.getSetpoint() + 0.1) && (this.getPosition() >= this.getSetpoint() -
 * 0.1)) { return true; } return false; }
 * 
 * @Override protected void end() { Robot.limelight.stopRobot(); }
 * 
 * @Override protected void interrupted() { }
 * 
 * @Override protected double returnPIDInput() { return
 * Robot.limelight.getDistance();
 * 
 * }
 * 
 * @Override protected void usePIDOutput(double output) {
 * Robot.limelight.trackPIDD(output); } }
 */