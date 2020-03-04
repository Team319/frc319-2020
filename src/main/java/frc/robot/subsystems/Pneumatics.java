/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {

  private Compressor compressor = new Compressor(1);

  /**
   * Creates a new Pneumatics.
   */
  public Pneumatics() {
    compressor.setClosedLoopControl(true);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void enableCompressor() {
    compressor.setClosedLoopControl(true);
  }

  public void disableCompressor() {
    compressor.setClosedLoopControl(false);
  }
}
