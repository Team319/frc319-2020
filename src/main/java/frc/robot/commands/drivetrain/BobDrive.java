/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.models.DriveSignal;
import frc.robot.Robot;
import frc.robot.utils.BobDriveHelper;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Add your docs here.
 */
public class BobDrive extends CommandBase {
    BobDriveHelper helper;
    private double quickTurnThreshold = 0.2;

    public BobDrive() {
        addRequirements(Robot.drivetrain);
        helper = new BobDriveHelper();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    public void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        double rotateValue = 0;

        // System.out.println("Drivetrain Mode" + Robot.drivetrain.mode);

        rotateValue = Robot.oi.driverController.rightStick.getX();

        double moveValue = -Robot.oi.driverController.leftStick.getY();
        boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
        DriveSignal driveSignal = helper.cheesyDrive(moveValue, rotateValue, quickTurn, false);
        Robot.drivetrain.drive(ControlMode.PercentOutput, driveSignal);
    }

    public boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
