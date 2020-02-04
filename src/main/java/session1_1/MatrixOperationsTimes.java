package session1_1;

public class MatrixOperationsTimes {

	public static void main(String[] args) {
		//int nTimes = Integer.parseInt(args[0]);
		int nTimes = 1000;
		try {
			measureSumDiagonal1(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		try {
			measureSumDiagonal2(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	private static void measureSumDiagonal1(int nTimes) {
		for (int i = 10; i < Integer.MAX_VALUE; i *= 3) {
			MatrixOperations mo = new MatrixOperations(i);

			long t1, t2;
			int s = 0;
			t1 = System.currentTimeMillis();
			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				s = mo.sumDiagonal1();
			}
			t2 = System.currentTimeMillis();

			System.out.println(String.format("METHOD 1:: SIZE = %d ** TIME = %d ms and the sum is %d", i, t2 - t1, s));
		}
	}

	private static void measureSumDiagonal2(int nTimes) {
		for (int i = 10; i < Integer.MAX_VALUE; i *= 3) {
			MatrixOperations mo = new MatrixOperations(i);

			long t1, t2;
			int s = 0;
			t1 = System.currentTimeMillis();
			for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
				s = mo.sumDiagonal2();
			}
			t2 = System.currentTimeMillis();

			System.out.println(String.format("METHOD 2:: SIZE = %d ** TIME = %d ms and the sum is %d", i, t2 - t1, s));
		}
	}
}
