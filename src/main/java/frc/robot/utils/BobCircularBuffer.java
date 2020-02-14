package frc.robot.utils;

import edu.wpi.first.wpiutil.CircularBuffer;

public class BobCircularBuffer extends CircularBuffer {

	int size = 0;

	public BobCircularBuffer(int size) {
		super(size);
		this.size = size;
	}

	public double[] toArray() {
		double[] arr = new double[this.size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = this.get(i);
		}

		return arr;
	}

}