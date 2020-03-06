package frc.robot.models;

import java.util.ArrayList;
import java.util.List;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * @author BigBa
 *
 */
public class LeaderBobTalonFX extends BobTalonFX {

	// a list of talons to follow the leader
	private final List<BaseMotorController> followerList;

	// the constructor
	/**
	 * @param leaderDeviceNumber
	 * @param followerDeviceNumbers
	 * @return
	 */

	public LeaderBobTalonFX(int leaderDeviceNumber, BaseMotorController... followers) {
		// the superconstructor
		super(leaderDeviceNumber);
		// create an empty list of followers
		followerList = new ArrayList<BaseMotorController>();

		// for each controller in the array,
		// tell it to follow the leader, and add it to the list
		// of followers
		for (BaseMotorController follower : followers) {
			follower.follow(this);
			// follower.setStatusFramePeriod(StatusFrame.Status_1_General, 100);
			// follower.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 100);
			followerList.add(follower);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctre.phoenix.motorcontrol.can.BaseMotorController#setNeutralMode(com.ctre
	 * .phoenix.motorcontrol.NeutralMode)
	 */
	@Override
	public void setNeutralMode(NeutralMode neutralMode) {
		super.setNeutralMode(neutralMode);
		for (BaseMotorController follower : followerList) {
			follower.setNeutralMode(neutralMode);
		}
	}

	@Override
	public void setInverted(boolean invert) {
		super.setInverted(invert);
		for (BaseMotorController follower : followerList) {
			follower.setInverted(invert);
		}
	}

	public ArrayList<Double> getSupplyCurrents() {
		ArrayList<Double> outputCurrents = new ArrayList<Double>();
		outputCurrents.add(super.getSupplyCurrent());
		for (BaseMotorController follower : followerList) {
			outputCurrents.add(((BobTalonSRX) follower).getSupplyCurrent());
		}
		return outputCurrents;
	}

	public double[] getSupplyCurrentArray() {
		int numMotors = 1 + followerList.size();
		double[] currents = new double[numMotors];
		currents[0] = this.getSupplyCurrent();
		for (int i = 1; i < numMotors; i++) {
			currents[i] = ((TalonSRX) followerList.get(i - 1)).getSupplyCurrent();
		}

		return currents;
	}

}
