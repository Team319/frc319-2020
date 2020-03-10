/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import com.team319.trajectory.Path;
import com.team319.trajectory.Path.SegmentValue;

/**
 * Add your docs here.
 */
public class PathTranslator {
    private Path prof;

    public PathTranslator(Path pathToTranslate) {
        this.prof = pathToTranslate;

    }

    public double getCenterPosition(int index) {
        return prof.getValue(index, SegmentValue.CENTER_POSITION);
    }
}
