package frc.robot.models;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class BobTalonFX extends TalonFX {
    private int defaultPidIndex = 0;

    public BobTalonFX(int deviceNumber) {
        super(deviceNumber);
        this.configNominalOutputForward(0.0);
        this.configNominalOutputReverse(0.0);
        this.configPeakOutputForward(1);
        this.configPeakOutputReverse(-1);
        this.configMotionProfileTrajectoryPeriod(0);
    }

    public int getDefaultPidIndex() {
        return this.defaultPidIndex;
    }

    public void setDefaultPidIndex(int pidIndex) {
        this.defaultPidIndex = pidIndex;
    }

    // ------------- HELPER METHODS -------- //

    public ErrorCode configPIDF(int slotIdx, double P, double I, double D, double F) {
        ErrorCode errorCode = ErrorCode.OK;

        errorCode = this.config_kP(slotIdx, P);
        if (errorCode != ErrorCode.OK) {
            return errorCode;
        }

        errorCode = this.config_kI(slotIdx, I);
        if (errorCode != ErrorCode.OK) {
            return errorCode;
        }

        errorCode = this.config_kD(slotIdx, D);
        if (errorCode != ErrorCode.OK) {
            return errorCode;
        }

        errorCode = this.config_kF(slotIdx, F);
        return errorCode;
    }

    public ErrorCode configPIDF(int slotIdx, double P, double I, double D, double F, int iZone) {
        ErrorCode eCode = this.configPIDF(slotIdx, P, I, D, F);
        eCode = this.config_IntegralZone(slotIdx, iZone);
        return eCode;
    }

    public ErrorCode configPIDF(PhoenixGains gains) {
        return this.configPIDF(gains.parameterSlot, gains.P, gains.I, gains.D, gains.F, gains.iZone);
    }

    public void configMotionParameters(MotionParameters parameters) {
        this.configMotionAcceleration(parameters.getAcceleration());
        this.configMotionCruiseVelocity(parameters.getCruiseVelocity());
        this.setGains(parameters.getGains());
    }

    public void selectMotionParameters(MotionParameters parameters) {
        this.selectProfileSlot(parameters.getGains().parameterSlot);
        this.configMotionAcceleration(parameters.getAcceleration());
        this.configMotionCruiseVelocity(parameters.getCruiseVelocity());
    }

    public ErrorCode setGains(PhoenixGains gains) {
        return this.configPIDF(gains.parameterSlot, gains.P, gains.I, gains.D, gains.F, gains.iZone);
    }

    public void selectProfileSlot(int slotIdx) {
        super.selectProfileSlot(slotIdx, defaultPidIndex);
    }
}