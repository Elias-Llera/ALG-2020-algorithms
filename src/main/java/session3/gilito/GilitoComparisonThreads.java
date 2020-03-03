package session3.gilito;

import java.util.Random;

public class GilitoComparisonThreads {
	public static void main(String arg[]) {
		Random r = new Random();
		int nTimes = 10;
		long t11, t12, t21, t22;
		int position1 = 0;
		int position2 = 0;
		
		for (int n = 10; n < Integer.MAX_VALUE; n *= 2) {
			Gilito2 gilito1 = new Gilito2(n);
			GilitoThreads gilito2 = new GilitoThreads(n);
			for (int i = 0; i < n; i++) {
				gilito1.setCoinWeight(i, Gilito1.REAL_WEIGHT); // authentic coins placed
				gilito2.setCoinWeight(i, Gilito1.REAL_WEIGHT);
			}
			int fakePosition = r.nextInt(n);
			gilito1.setCoinWeight(fakePosition, Gilito1.FAKE_WEIGHT); //fake coin placement
			gilito2.setCoinWeight(fakePosition, Gilito2.FAKE_WEIGHT);

			t11 = System.currentTimeMillis();
			for (int i = 0; i < nTimes; i++) {
				position1 = gilito1.calculate();
			}
			t12 = System.currentTimeMillis();
			t21 = System.currentTimeMillis();
			for (int i = 0; i < nTimes; i++) {
				position2 = gilito2.calculate();
			}
			t22 = System.currentTimeMillis();
			
			System.out.println(String.format("CLASSIC: N=%d P=%d E=%d T=%d", n,
					position1, gilito1.getUsedWatts() / nTimes, t12 - t11));
			System.out.println(String.format("IMPROVED: N=%d P=%d E=%d T=%d", n,
					position2, gilito2.getUsedWatts() / nTimes, t22 - t21));
			System.out.println();
		}
	}
}
