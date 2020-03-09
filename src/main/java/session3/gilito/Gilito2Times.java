package session3.gilito;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Gilito2Times {
	public static void main(String arg[]) {
		int nTimes = 100;
		long t1, t2, total = 0;
		FileWriter fileTimes = null;
		PrintWriter pwTimes = null;
		FileWriter fileEnergy = null;
		PrintWriter pwEnergy = null;

		try {
			fileTimes = new FileWriter("gilito2-Times.txt");
			pwTimes = new PrintWriter(fileTimes);
			fileEnergy = new FileWriter("gilito2-Energy.txt");
			pwEnergy = new PrintWriter(fileEnergy);
			int position = 0;
			for (int n = 10; n < Integer.MAX_VALUE; n *= 2) {
				Gilito2 gilito = new Gilito2(n);
				for (int i = 0; i < n; i++)
					gilito.setCoinWeight(i, Gilito1.REAL_WEIGHT); // authentic coin weight
				gilito.setCoinWeight(n - 1, Gilito1.FAKE_WEIGHT); // worst case (last coin is the fake one)

				t1 = System.currentTimeMillis();
				for (int i = 0; i < nTimes; i++)
					position = gilito.calculate();
				t2 = System.currentTimeMillis();
				total = t2 - t1;
				
				System.out
						.println(String.format("IMPROVED: NCOINS=%d FAKE_POSITION=%d ENERGY_USED=%d TIME=%d NTIMES=%d",
								n, position, gilito.getUsedWatts() / nTimes, total, nTimes));
				pwTimes.println(total);
				pwEnergy.println(gilito.getUsedWatts() / nTimes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileTimes != null && fileEnergy != null)
					fileTimes.close();
				fileEnergy.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
