/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.oi;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RumbleOperatorController extends InstantCommand {
  // private double rumbleIntensity = 0;

  public RumbleOperatorController(double intensity) {
    // rumbleIntensity = intensity;
  }

  @Override
  public void initialize() {
    // Robot.oi.operatorController.setRumble(rumbleIntensity, rumbleIntensity);
  }
}
