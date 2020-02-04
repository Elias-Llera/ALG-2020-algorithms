package session1_1;

public class Vector4 {

	public static void main(String[] args) {
		//int nTimes = Integer.parseInt(args[0]);
		int nTimes = 1000;
		try {
			measureFillIn(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		try {
			measureSum(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		try {
			measureMaximum(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	private static void measureFillIn(int nTimes) {
		for (int i = 10; i < Integer.MAX_VALUE; i *= 3) {
			int[] v = new int[i];

			long t1, t2;
			t1 = System.currentTimeMillis();
			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				Vector1.fillIn(v);
			}
			t2 = System.currentTimeMillis();

			System.out.println(String.format("FILL IN MEASURE:: SIZE = %d ** TIME = %d ms", i, t2 - t1));
		}
	}

	private static void measureSum(int nTimes) {
		for (int i = 10; i < Integer.MAX_VALUE; i *= 3) {
			int[] v = new int[i];
			Vector1.fillIn(v);

			long t1, t2;
			int s = 0;
			t1 = System.currentTimeMillis();
			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				s = Vector1.sum(v);
			}
			t2 = System.currentTimeMillis();

			System.out
					.println(String.format("SUM MEASURE:: SIZE = %d ** TIME = %d ms and the sum is %d", i, t2 - t1, s));
		}
	}

	private static void measureMaximum(int nTimes) {
		for (int i = 10; i < Integer.MAX_VALUE; i *= 3) {
			int[] v = new int[i];
			Vector1.fillIn(v);

			long t1, t2;
			int[] s = new int[2];
			t1 = System.currentTimeMillis();
			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				Vector1.maximum(v, s);
			}
			t2 = System.currentTimeMillis();

			System.out.println(String.format("MAXIMUM MEASURE:: SIZE = %d ** TIME = %d ms and the maximum is [%d, %d]",
					i, t2 - t1, s[0], s[1]));
		}
	}

}
