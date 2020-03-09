/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.collector.CollectOut;
import frc.robot.commands.collector.CollectorStartCollect;
import frc.robot.commands.collector.CollectorStopCollect;
import frc.robot.commands.collector.StopCollecting;
import frc.robot.commands.limelight.StartLimelightMode;
import frc.robot.commands.limelight.StopLimelightMode;
import frc.robot.commands.robot.Preload;
import frc.robot.commands.robot.SetRobotMode;
import frc.robot.commands.robot.StopPreload;
import frc.robot.commands.robot.StopShooting;
import frc.robot.commands.robot.StopUnjam;
import frc.robot.commands.robot.Unjam;
import frc.robot.commands.shooter.ShootCommand;
import frc.robot.commands.turret.ResetTurret;
import frc.robot.controllers.BobXboxController;
import frc.robot.models.RobotMode;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;

    public OI() {
        driverController = new BobXboxController(0, 0.1, 0.2);
        operatorController = new BobXboxController(1, 0.2, 0.2);

        // Driver Controls
        driverController.rightTriggerButton.whenPressed(new ShootCommand(0.65));
        driverController.rightTriggerButton.whenReleased(new StopShooting());

        driverController.leftTriggerButton.whenPressed(new StartLimelightMode());
        driverController.leftTriggerButton.whenReleased(new StopLimelightMode());

        driverController.rightBumper.whenPressed(new CollectorStartCollect());
        driverController.bButton.whenPressed(new CollectorStopCollect());
        driverController.leftBumper.whenPressed(new StopCollecting());

        // Operator Controls
        operatorController.rightBumper.whenPressed(new CollectorStartCollect());
        operatorController.leftTriggerButton.whenPressed(new StopCollecting());
        operatorController.leftBumper.whenPressed(new CollectOut(0.5));
        operatorController.leftBumper.whenReleased(new CollectOut(0));

        operatorController.rightTriggerButton.whenPressed(new CollectorStopCollect());

        operatorController.startButton.whenPressed(new SetRobotMode(RobotMode.Climb));
        // operatorController.selectButton.whenPressed(new ResetTurret());

        operatorController.bButton.whenPressed(new Unjam());
        operatorController.bButton.whenReleased(new StopUnjam());

        operatorController.aButton.whenPressed(new Preload());
        operatorController.aButton.whenReleased(new StopPreload());

    }

}
