package session5.check;

import java.io.FileWriter;
import java.io.PrintWriter;

import session5.Exchange;

public class ExchangeTimes {
	public static void main(String arg[]) {
		Exchange ex;
		int nTimes = 100;
		long t1, t2, totalTime;
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			file = new FileWriter("exchange-times.txt");
			pw = new PrintWriter(file);
			
			for (int n = 10000; n < Integer.MAX_VALUE; n *= 2) {
				ex = new Exchange("src/main/java/session5/check/tests.txt");

				t1 = System.currentTimeMillis();
				for (int i = 0; i < nTimes; i++)
					ex.getNumCoins(n);
				t2 = System.currentTimeMillis();
				totalTime = t2 - t1;

				pw.println(totalTime);
				System.out.println("N = " + n + ", TIME = " + totalTime);

				if (totalTime > 50000) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
