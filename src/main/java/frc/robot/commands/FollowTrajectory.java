package frc.robot.commands;

//
// import com.ctre.phoenix.motion.MotionProfileStatus;
// import com.ctre.phoenix.motion.SetValueMotionProfile;
// import com.ctre.phoenix.motion.TrajectoryPoint;
// import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//
// import edu.wpi.first.wpilibj.Notifier;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Robot;
// import frc.robot.models.BobTalonFX;
// import frc.robot.models.BobTalonSRX;
// import frc.robot.models.SrxMotionProfile;
// import frc.robot.models.SrxTrajectory;
//
// public class FollowTrajectory extends CommandBase {
//
// private BobTalonFX rightTalon = Robot.drivetrain.rightLead;
// private BobTalonFX leftTalon = Robot.drivetrain.leftLead;
//
// private String trajectoryName = "";
// private int kMinPointsInTalon = 5;
//
// private boolean isFinished = false;
//
// private SrxTrajectory trajectoryToFollow = null;
//
// private MotionProfileStatus rightStatus = new MotionProfileStatus();
// private MotionProfileStatus leftStatus = new MotionProfileStatus();
//
// private boolean hasPathStarted = false;
//
// /**
// * this is only either Disable, Enable, or Hold. Since we'd never want one
// side
// * to be enabled while the other is disabled, we'll use the same status for
// both
// * sides.
// */
// private SetValueMotionProfile setValue = SetValueMotionProfile.Disable;
//
// private class BufferLoader implements java.lang.Runnable {
// private int leftLastPointSent = 0;
// private int rightLastPointSent = 0;
//
// public BufferLoader() {
// this.leftLastPointSent = 0;
// this.rightLastPointSent = 0;
// }
//
// public void run() {
// leftTalon.processMotionProfileBuffer();
// rightTalon.processMotionProfileBuffer();
// leftLastPointSent = manageBuffer(leftTalon, trajectoryToFollow.leftProfile,
// Robot.drivetrain.DRIVE_PROFILE, leftLastPointSent);
// rightLastPointSent = manageBuffer(rightTalon,
// trajectoryToFollow.rightProfile,
// Robot.drivetrain.DRIVE_PROFILE, rightLastPointSent);
// }
//
// private int manageBuffer(BobTalonFX leftTalon, SrxMotionProfile prof, int
// pidfSlot, int lastPointSent) {
// if (lastPointSent >= prof.numPoints) {
// return lastPointSent;
// }
//
// if (!leftTalon.isMotionProfileTopLevelBufferFull() && lastPointSent <
// prof.numPoints) {
// TrajectoryPoint point = new TrajectoryPoint();
// /* for each point, fill our structure and pass it to API */
// point.position = prof.points[lastPointSent][0];
// point.velocity = prof.points[lastPointSent][1];
// point.timeDur = getTrajectoryDuration((int) prof.points[lastPointSent][2]);
// point.profileSlotSelect0 = pidfSlot;
// point.profileSlotSelect1 = pidfSlot;
// point.zeroPos = false;
// if (lastPointSent == 0) {
// point.zeroPos = true; /* set this to true on the first point */
//
// }
// point.isLastPoint = false;
// if ((lastPointSent + 1) == prof.numPoints) {
// point.isLastPoint = true; /* set this to true on the last point */
// }
// leftTalon.pushMotionProfileTrajectory(point);
// lastPointSent++;
// }
// return lastPointSent;
// }
//
// private TrajectoryDuration getTrajectoryDuration(int ms) {
// TrajectoryDuration retval = TrajectoryDuration.Trajectory_Duration_0ms;
//
// retval = retval.valueOf(ms);
//
// return retval;
// }
//
// }
//
// // Runs the runnable
// private Notifier bufferNotifier;
//
// // constructor
// public FollowTrajectory(String trajectoryName) {
// addRequirements(Robot.drivetrain);
// this.trajectoryName = trajectoryName;
// }
//
// public FollowTrajectory(SrxTrajectory trajectoryToFollow) {
// addRequirements(Robot.drivetrain);
// this.trajectoryToFollow = trajectoryToFollow;
// }
//
// // Called just before this Command runs the first time
// public void initialize() {
// this.hasPathStarted = false;
// setUpTalon(rightTalon);
// setUpTalon(leftTalon);
//
// setValue = SetValueMotionProfile.Disable;
//
// leftTalon.set(ControlMode.MotionProfile, setValue.value);
// rightTalon.set(ControlMode.MotionProfile, setValue.value);
//
// bufferNotifier = new Notifier(new BufferLoader());
// bufferNotifier.startPeriodic(.005);
// }
//
// // Called repeatedly when this Command is scheduled to run
// public void execute() {
//
// rightTalon.getMotionProfileStatus(rightStatus);
// leftTalon.getMotionProfileStatus(leftStatus);
//
// if (rightStatus.isUnderrun || leftStatus.isUnderrun) {
// // if either MP has underrun, stop both
// System.out.println("Motion profile has underrun!");
// setValue = SetValueMotionProfile.Disable;
// } else if (rightStatus.btmBufferCnt > kMinPointsInTalon &&
// leftStatus.btmBufferCnt > kMinPointsInTalon) {
// // if we have enough points in the talon, go.
// setValue = SetValueMotionProfile.Enable;
// hasPathStarted = true;
// } else if (rightStatus.activePointValid && rightStatus.isLast &&
// leftStatus.activePointValid
// && leftStatus.isLast) {
// // if both profiles are at their last points, hold the last point
// setValue = SetValueMotionProfile.Hold;
// // System.out.println("HOLDING LAST POINT!!!!!");
// }
//
// leftTalon.set(ControlMode.MotionProfile, setValue.value);
// rightTalon.set(ControlMode.MotionProfile, setValue.value);
// }
//
// // Make this return true when this Command no longer needs to run execute()
// public boolean isFinished() {
// if (!hasPathStarted) {
// return false;
// }
// boolean leftComplete = leftStatus.activePointValid && leftStatus.isLast;
// boolean rightComplete = rightStatus.activePointValid && rightStatus.isLast;
// // System.out.println("Complete: " + leftComplete + "," + rightComplete);
// boolean trajectoryComplete = leftComplete && rightComplete;
// if (trajectoryComplete) {
// System.out.println("Finished Trajectory");
// }
// return trajectoryComplete || isFinished;
// }
//
// // Called once after isFinished returns true
// protected void end() {
// cleanUp();
// }
//
// // Called when another command which requires one or more of the same
// // subsystems is scheduled to run
// protected void interrupted() {
// cleanUp();
// }
//
// public void cleanUp() {
// resetTalon(rightTalon, ControlMode.PercentOutput, 0);
// resetTalon(leftTalon, ControlMode.PercentOutput, 0);
// bufferNotifier.stop();
// }
//
// // set up the talon for motion profile control
// public void setUpTalon(BobTalonFX rightTalon2) {
// rightTalon2.clearMotionProfileTrajectories();
// rightTalon2.changeMotionControlFramePeriod(5);
// }
//
// // set the to the desired controlMode
// // used at the end of the motion profile
// public void resetTalon(BobTalonFX rightTalon2, ControlMode controlMode,
// double setValue) {
// // System.out.println("Clearing MP Trajectories");
// rightTalon2.clearMotionProfileTrajectories();
// rightTalon2.set(ControlMode.MotionProfile,
// SetValueMotionProfile.Disable.value);
// rightTalon2.set(controlMode, setValue);
// }
// }