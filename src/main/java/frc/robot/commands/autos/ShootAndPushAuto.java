/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.DriveCommand;
import frc.robot.commands.robot.StopShooting;
import frc.robot.commands.shooter.ShootCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootAndPushAuto extends SequentialCommandGroup {
  /**
   * Creates a new ShootAndPushAuto.
   */
  public ShootAndPushAuto() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(new ShootCommand(0.50), new WaitCommand(3), new StopShooting(), new DriveCommand(-0.25),
        new WaitCommand(2), new DriveCommand(0.15), new WaitCommand(2), new DriveCommand(0));
  }
}
