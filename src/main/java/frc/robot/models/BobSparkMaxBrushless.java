/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.models;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

public class BobSparkMaxBrushless extends CANSparkMax {
    private CANPIDController _pidController;

    public BobSparkMaxBrushless(int deviceNumber) {
        super(deviceNumber, MotorType.kBrushless);
        _pidController = this.getPIDController();
    }

    public void set(double setpoint, ControlType controlType) {
        this._pidController.setReference(setpoint, controlType);
    }

    public CANError configPIDF(int slotIdx, double P, double I, double D, double F) {
        CANError errorCode = CANError.kOk;

        errorCode = this._pidController.setP(P, slotIdx);
        if (errorCode != CANError.kOk) {
            return errorCode;
        }

        errorCode = this._pidController.setI(I, slotIdx);
        if (errorCode != CANError.kOk) {
            return errorCode;
        }

        errorCode = this._pidController.setD(D, slotIdx);
        if (errorCode != CANError.kOk) {
            return errorCode;
        }

        errorCode = this._pidController.setFF(F, slotIdx);
        return errorCode;
    }

    public CANError configPIDF(int slotIdx, double P, double I, double D, double F, int iZone) {
        CANError eCode = this.configPIDF(slotIdx, P, I, D, F);
        eCode = this._pidController.setIZone(iZone, slotIdx);
        return eCode;
    }

    public CANError configPIDF(PidGains gains) {
        return this.configPIDF(gains.slot, gains.P, gains.I, gains.D, gains.F, gains.iZone);
    }

    public void configMotionParameters(MotionParameters parameters) {
        this._pidController.setSmartMotionMaxAccel(parameters.getAcceleration(), parameters.getGains().slot);
        this._pidController.setSmartMotionMaxVelocity(parameters.getCruiseVelocity(), parameters.getGains().slot);
        this.setGains(parameters.getGains());
    }

    public void selectMotionParameters(MotionParameters parameters) {
        this.selectProfileSlot(parameters.getGains().slot);
        this._pidController.setSmartMotionMaxAccel(parameters.getAcceleration(), parameters.getGains().slot);
        this._pidController.setSmartMotionMaxVelocity(parameters.getCruiseVelocity(), parameters.getGains().slot);
    }

    public CANError setGains(PidGains gains) {
        return this.configPIDF(gains.slot, gains.P, gains.I, gains.D, gains.F, gains.iZone);
    }

    public void selectProfileSlot(int slotIdx) {
        this.selectProfileSlot(slotIdx);
    }
}
