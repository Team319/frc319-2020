/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.commands.collector.SpinCollector;
import frc.robot.commands.shooter.ShooterClosedLoop;
import frc.robot.commands.shooter.SpinShooter;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;

    public OI() {
        driverController = new BobXboxController(0, 0.1, 0.1);

        driverController.aButton.whenPressed(new ShooterClosedLoop());
        driverController.aButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0.0));

        driverController.bButton.whenPressed(new SpinCollector(ControlMode.PercentOutput, 0.35));
        driverController.bButton.whenReleased(new SpinCollector(ControlMode.PercentOutput, 0.0));
    }

}
