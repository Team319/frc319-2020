/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.models;

/**
 * Add your docs here.
 */
public interface IPositionControlledSubsystem {

    public int targetPosition = 0;
    public int onTargetThreshold = 0;

    public boolean setTargetPosition(int targetPosition);

    public int getTargetPosition();

    public int getCurrentPosition();

    public double getCurrentVelocity();

    public void motionMagicControl();

    public boolean isInPosition(int targetPosition);
}
