/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.shooter.SpinShooter;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;

    public OI() {
        driverController = new BobXboxController(0, 0.1, 0.1);

        driverController.aButton.whenPressed(new SpinShooter(0.35));
        driverController.aButton.whenReleased(new SpinShooter(0.0));
    }

}
