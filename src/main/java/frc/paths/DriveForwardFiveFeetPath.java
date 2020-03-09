package frc.paths;

import com.team319.trajectory.Path;

public class DriveForwardFiveFeetPath extends Path {
	// dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
			{ 0.0200, 32.9972, -7.0000, 0.0028, 0.1400, 7.0000, 0.0000, 0.0028, 0.1400, 7.0000, 0.0000, 0.0028, 0.1400,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.9916, -7.0000, 0.0084, 0.2800, 7.0000, 0.0000, 0.0084, 0.2800, 7.0000, 0.0000, 0.0084, 0.2800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.9832, -7.0000, 0.0168, 0.4200, 7.0000, -0.0000, 0.0168, 0.4200, 7.0000, 0.0000, 0.0168, 0.4200,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.9720, -7.0000, 0.0280, 0.5600, 7.0000, -0.0000, 0.0280, 0.5600, 7.0000, 0.0000, 0.0280, 0.5600,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.9580, -7.0000, 0.0420, 0.7000, 7.0000, 0.0000, 0.0420, 0.7000, 7.0000, 0.0000, 0.0420, 0.7000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.9412, -7.0000, 0.0588, 0.8400, 7.0000, -0.0000, 0.0588, 0.8400, 7.0000, 0.0000, 0.0588, 0.8400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.9216, -7.0000, 0.0784, 0.9800, 7.0000, -0.0000, 0.0784, 0.9800, 7.0000, 0.0000, 0.0784, 0.9800,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.8992, -7.0000, 0.1008, 1.1200, 7.0000, 0.0000, 0.1008, 1.1200, 7.0000, 0.0000, 0.1008, 1.1200,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.8740, -7.0000, 0.1260, 1.2600, 7.0000, -0.0000, 0.1260, 1.2600, 7.0000, 0.0000, 0.1260, 1.2600,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.8460, -7.0000, 0.1540, 1.4000, 7.0000, 0.0000, 0.1540, 1.4000, 7.0000, 0.0000, 0.1540, 1.4000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.8152, -7.0000, 0.1848, 1.5400, 7.0000, -0.0000, 0.1848, 1.5400, 7.0000, 0.0000, 0.1848, 1.5400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.7816, -7.0000, 0.2184, 1.6800, 7.0000, 0.0000, 0.2184, 1.6800, 7.0000, 0.0000, 0.2184, 1.6800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.7452, -7.0000, 0.2548, 1.8200, 7.0000, -0.0000, 0.2548, 1.8200, 7.0000, 0.0000, 0.2548, 1.8200,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.7060, -7.0000, 0.2940, 1.9600, 7.0000, 0.0000, 0.2940, 1.9600, 7.0000, 0.0000, 0.2940, 1.9600,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.6640, -7.0000, 0.3360, 2.1000, 7.0000, 0.0000, 0.3360, 2.1000, 7.0000, 0.0000, 0.3360, 2.1000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.6192, -7.0000, 0.3808, 2.2400, 7.0000, -0.0000, 0.3808, 2.2400, 7.0000, 0.0000, 0.3808, 2.2400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.5716, -7.0000, 0.4284, 2.3800, 7.0000, -0.0000, 0.4284, 2.3800, 7.0000, 0.0000, 0.4284, 2.3800,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.5212, -7.0000, 0.4788, 2.5200, 7.0000, 0.0000, 0.4788, 2.5200, 7.0000, 0.0000, 0.4788, 2.5200,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.4680, -7.0000, 0.5320, 2.6600, 7.0000, 0.0000, 0.5320, 2.6600, 7.0000, 0.0000, 0.5320, 2.6600,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.4120, -7.0000, 0.5880, 2.8000, 7.0000, -0.0000, 0.5880, 2.8000, 7.0000, 0.0000, 0.5880, 2.8000,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.3532, -7.0000, 0.6468, 2.9400, 7.0000, -0.0000, 0.6468, 2.9400, 7.0000, 0.0000, 0.6468, 2.9400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.2916, -7.0000, 0.7084, 3.0800, 7.0000, -0.0000, 0.7084, 3.0800, 7.0000, 0.0000, 0.7084, 3.0800,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 32.2272, -7.0000, 0.7728, 3.2200, 7.0000, 0.0000, 0.7728, 3.2200, 7.0000, 0.0000, 0.7728, 3.2200,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.1600, -7.0000, 0.8400, 3.3600, 7.0000, 0.0000, 0.8400, 3.3600, 7.0000, 0.0000, 0.8400, 3.3600,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.0900, -7.0000, 0.9100, 3.5000, 7.0000, 0.0000, 0.9100, 3.5000, 7.0000, 0.0000, 0.9100, 3.5000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 32.0172, -7.0000, 0.9828, 3.6400, 7.0000, -0.0000, 0.9828, 3.6400, 7.0000, 0.0000, 0.9828, 3.6400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.9416, -7.0000, 1.0584, 3.7800, 7.0000, 0.0000, 1.0584, 3.7800, 7.0000, 0.0000, 1.0584, 3.7800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 31.8632, -7.0000, 1.1368, 3.9200, 7.0000, -0.0000, 1.1368, 3.9200, 7.0000, 0.0000, 1.1368, 3.9200,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.7820, -7.0000, 1.2180, 4.0600, 7.0000, 0.0000, 1.2180, 4.0600, 7.0000, 0.0000, 1.2180, 4.0600,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 31.6980, -7.0000, 1.3020, 4.2000, 7.0000, 0.0000, 1.3020, 4.2000, 7.0000, 0.0000, 1.3020, 4.2000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 31.6112, -7.0000, 1.3888, 4.3400, 7.0000, -0.0000, 1.3888, 4.3400, 7.0000, 0.0000, 1.3888, 4.3400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.5216, -7.0000, 1.4784, 4.4800, 7.0000, 0.0000, 1.4784, 4.4800, 7.0000, 0.0000, 1.4784, 4.4800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 31.4292, -7.0000, 1.5708, 4.6200, 7.0000, -0.0000, 1.5708, 4.6200, 7.0000, 0.0000, 1.5708, 4.6200,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.3340, -7.0000, 1.6660, 4.7600, 7.0000, -0.0000, 1.6660, 4.7600, 7.0000, 0.0000, 1.6660, 4.7600,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.2360, -7.0000, 1.7640, 4.9000, 7.0000, 0.0000, 1.7640, 4.9000, 7.0000, 0.0000, 1.7640, 4.9000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 31.1352, -7.0000, 1.8648, 5.0400, 7.0000, -0.0000, 1.8648, 5.0400, 7.0000, 0.0000, 1.8648, 5.0400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 31.0316, -7.0000, 1.9684, 5.1800, 7.0000, 0.0000, 1.9684, 5.1800, 7.0000, 0.0000, 1.9684, 5.1800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 30.9252, -7.0000, 2.0748, 5.3200, 7.0000, 0.0000, 2.0748, 5.3200, 7.0000, 0.0000, 2.0748, 5.3200,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 30.8160, -7.0000, 2.1840, 5.4600, 7.0000, -0.0000, 2.1840, 5.4600, 7.0000, 0.0000, 2.1840, 5.4600,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 30.7040, -7.0000, 2.2960, 5.6000, 7.0000, 0.0000, 2.2960, 5.6000, 7.0000, 0.0000, 2.2960, 5.6000,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 30.5892, -7.0000, 2.4108, 5.7400, 7.0000, -0.0000, 2.4108, 5.7400, 7.0000, 0.0000, 2.4108, 5.7400,
					7.0000, -0.0000, 3.1416 },
			{ 0.0200, 30.4716, -7.0000, 2.5284, 5.8800, 7.0000, 0.0000, 2.5284, 5.8800, 7.0000, 0.0000, 2.5284, 5.8800,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 30.3512, -7.0000, 2.6488, 6.0200, 7.0000, 0.0000, 2.6488, 6.0200, 7.0000, 0.0000, 2.6488, 6.0200,
					7.0000, 0.0000, 3.1416 },
			{ 0.0200, 30.2336, -7.0000, 2.7664, 5.8800, -7.0000, -700.0000, 2.7664, 5.8800, -7.0000, 0.0000, 2.7664,
					5.8800, -7.0000, -700.0000, 3.1416 },
			{ 0.0200, 30.1188, -7.0000, 2.8812, 5.7400, -7.0000, -0.0000, 2.8812, 5.7400, -7.0000, 0.0000, 2.8812,
					5.7400, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 30.0068, -7.0000, 2.9932, 5.6000, -7.0000, 0.0000, 2.9932, 5.6000, -7.0000, 0.0000, 2.9932,
					5.6000, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.8976, -7.0000, 3.1024, 5.4600, -7.0000, 0.0000, 3.1024, 5.4600, -7.0000, 0.0000, 3.1024,
					5.4600, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.7912, -7.0000, 3.2088, 5.3200, -7.0000, -0.0000, 3.2088, 5.3200, -7.0000, 0.0000, 3.2088,
					5.3200, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 29.6876, -7.0000, 3.3124, 5.1800, -7.0000, 0.0000, 3.3124, 5.1800, -7.0000, 0.0000, 3.3124,
					5.1800, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.5868, -7.0000, 3.4132, 5.0400, -7.0000, 0.0000, 3.4132, 5.0400, -7.0000, 0.0000, 3.4132,
					5.0400, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.4888, -7.0000, 3.5112, 4.9000, -7.0000, -0.0000, 3.5112, 4.9000, -7.0000, 0.0000, 3.5112,
					4.9000, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 29.3936, -7.0000, 3.6064, 4.7600, -7.0000, 0.0000, 3.6064, 4.7600, -7.0000, 0.0000, 3.6064,
					4.7600, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.3012, -7.0000, 3.6988, 4.6200, -7.0000, -0.0000, 3.6988, 4.6200, -7.0000, 0.0000, 3.6988,
					4.6200, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 29.2116, -7.0000, 3.7884, 4.4800, -7.0000, 0.0000, 3.7884, 4.4800, -7.0000, 0.0000, 3.7884,
					4.4800, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.1248, -7.0000, 3.8752, 4.3400, -7.0000, 0.0000, 3.8752, 4.3400, -7.0000, 0.0000, 3.8752,
					4.3400, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 29.0408, -7.0000, 3.9592, 4.2000, -7.0000, 0.0000, 3.9592, 4.2000, -7.0000, 0.0000, 3.9592,
					4.2000, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.9596, -7.0000, 4.0404, 4.0600, -7.0000, -0.0000, 4.0404, 4.0600, -7.0000, 0.0000, 4.0404,
					4.0600, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.8812, -7.0000, 4.1188, 3.9200, -7.0000, 0.0000, 4.1188, 3.9200, -7.0000, 0.0000, 4.1188,
					3.9200, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.8056, -7.0000, 4.1944, 3.7800, -7.0000, 0.0000, 4.1944, 3.7800, -7.0000, 0.0000, 4.1944,
					3.7800, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.7328, -7.0000, 4.2672, 3.6400, -7.0000, -0.0000, 4.2672, 3.6400, -7.0000, 0.0000, 4.2672,
					3.6400, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.6628, -7.0000, 4.3372, 3.5000, -7.0000, 0.0000, 4.3372, 3.5000, -7.0000, 0.0000, 4.3372,
					3.5000, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.5956, -7.0000, 4.4044, 3.3600, -7.0000, -0.0000, 4.4044, 3.3600, -7.0000, 0.0000, 4.4044,
					3.3600, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.5312, -7.0000, 4.4688, 3.2200, -7.0000, 0.0000, 4.4688, 3.2200, -7.0000, 0.0000, 4.4688,
					3.2200, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.4696, -7.0000, 4.5304, 3.0800, -7.0000, -0.0000, 4.5304, 3.0800, -7.0000, 0.0000, 4.5304,
					3.0800, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.4108, -7.0000, 4.5892, 2.9400, -7.0000, -0.0000, 4.5892, 2.9400, -7.0000, 0.0000, 4.5892,
					2.9400, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.3548, -7.0000, 4.6452, 2.8000, -7.0000, 0.0000, 4.6452, 2.8000, -7.0000, 0.0000, 4.6452,
					2.8000, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.3016, -7.0000, 4.6984, 2.6600, -7.0000, 0.0000, 4.6984, 2.6600, -7.0000, 0.0000, 4.6984,
					2.6600, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.2512, -7.0000, 4.7488, 2.5200, -7.0000, -0.0000, 4.7488, 2.5200, -7.0000, 0.0000, 4.7488,
					2.5200, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.2036, -7.0000, 4.7964, 2.3800, -7.0000, 0.0000, 4.7964, 2.3800, -7.0000, 0.0000, 4.7964,
					2.3800, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.1588, -7.0000, 4.8412, 2.2400, -7.0000, -0.0000, 4.8412, 2.2400, -7.0000, 0.0000, 4.8412,
					2.2400, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.1168, -7.0000, 4.8832, 2.1000, -7.0000, 0.0000, 4.8832, 2.1000, -7.0000, 0.0000, 4.8832,
					2.1000, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0776, -7.0000, 4.9224, 1.9600, -7.0000, 0.0000, 4.9224, 1.9600, -7.0000, 0.0000, 4.9224,
					1.9600, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0412, -7.0000, 4.9588, 1.8200, -7.0000, 0.0000, 4.9588, 1.8200, -7.0000, 0.0000, 4.9588,
					1.8200, -7.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0076, -7.0000, 4.9924, 1.6800, -7.0000, -0.0000, 4.9924, 1.6800, -7.0000, 0.0000, 4.9924,
					1.6800, -7.0000, -0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.3800, -65.0000, -2900.0000, 5.0000, 1.5400, -7.0000, 0.0000, 5.0000,
					0.3800, -65.0000, -2900.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, -19.0000, 2300.0000, 5.0000, 1.4000, -7.0000, 0.0000, 5.0000,
					0.0000, -19.0000, 2300.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 950.0000, 5.0000, 1.2600, -7.0000, 0.0000, 5.0000,
					0.0000, 0.0000, 950.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 1.1200, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.9800, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.8400, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.7000, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.5600, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.4200, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.2800, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, 0.1400, -7.0000, 0.0000, 5.0000, 0.0000,
					0.0000, 0.0000, 3.1416 },
			{ 0.0200, 28.0000, -7.0000, 5.0000, 0.0000, 0.0000, 0.0000, 5.0000, -0.0000, -7.0000, 0.0000, 5.0000,
					0.0000, 0.0000, 0.0000, 3.1416 },

	};

	@Override
	public double[][] getPath() {
		return points;
	}
}