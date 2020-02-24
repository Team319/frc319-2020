/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.collector.CollectOut;
import frc.robot.commands.limelight.StartLimelightMode;
import frc.robot.commands.limelight.StopLimelightMode;
import frc.robot.commands.robot.FeedShooter;
import frc.robot.commands.robot.StopFeedShooter;
import frc.robot.commands.shooter.ShooterClosedLoop;
import frc.robot.commands.shooter.SpinShooter;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;

    public OI() {
        driverController = new BobXboxController(0, 0.2, 0.2);
        operatorController = new BobXboxController(1, 0.2, 0.2);

        driverController.rightTriggerButton.whenPressed(new FeedShooter());
        driverController.rightTriggerButton.whenReleased(new StopFeedShooter());
        driverController.leftTriggerButton.whenPressed(new StartLimelightMode());
        driverController.leftTriggerButton.whenReleased(new StopLimelightMode());

        operatorController.rightBumper.whenPressed(new CollectIn(0.8));
        operatorController.rightBumper.whenReleased(new CollectIn(0));
        operatorController.rightTriggerButton.whenPressed(new CollectIn(0.0));
    }

}
