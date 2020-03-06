/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.robot;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.collector.CollectIn;
import frc.robot.commands.serializer.SerializeOut;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Unjam extends ParallelRaceGroup {
  /**
   * Creates a new Unjam.
   */
  public Unjam() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(new CollectIn(0.5), new SerializeOut(0.5));
  }
}