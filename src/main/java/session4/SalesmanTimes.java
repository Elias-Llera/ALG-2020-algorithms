package session4;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SalesmanTimes {
	public static void main(String arg[]) {
		Salesman s;
		int nTimes = 250;
		long t1, t2, totalTime;
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			file = new FileWriter("greedy1-times.txt");
			pw = new PrintWriter(file);
			
			for (int n = 10; n < Integer.MAX_VALUE; n *= 2) {
				s = new Salesman(n, 15);

				t1 = System.currentTimeMillis();
				for (int i = 0; i < nTimes; i++)
					s.greedy1(0);
				t2 = System.currentTimeMillis();
				totalTime = t2 - t1;

				pw.println(totalTime);
				System.out.println("N = " + n + ", TIME = " + totalTime);

				if (totalTime > 30 * 60000) {
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
