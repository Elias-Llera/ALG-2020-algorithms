package session1_2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Loop3 {
	public static void loop3(int n) {
		Random rn = new Random();
		@SuppressWarnings("unused")
		int cont = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				cont += rn.nextInt();
	}

	public static void main(String arg[]) {
		long t1, t2;
		// int nTimes= Integer.parseInt(arg [0]);
		int nTimes = 500;
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			file = new FileWriter("loop3.txt");
			pw = new PrintWriter(file);

			for (int n = 1, r = 0; n <= Integer.MAX_VALUE; n *= 2, r++) {
				if (r == 13)
					break;
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					loop3(n);
				}
				t2 = System.currentTimeMillis();

				pw.println(t2 - t1);
				System.out.println("n=" + n + "**TIME=" + (t2 - t1) + " **nTimes=" + nTimes);
			} // for

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
	} // main
} // class