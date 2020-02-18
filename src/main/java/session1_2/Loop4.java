package session1_2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Loop4 {

	public static long unknown(int n) {
		long cont = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				for (int k = 1; k <= j; k++)
					for (int l = 1; l <= k; l++)
						cont++;
		return cont;
	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;
		// int nTimes = Integer.parseInt(arg[0]);
		int nTimes = 100;
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("loop4.txt");
			pw = new PrintWriter(file);

			for (int n = 1, r = 0; n <= Integer.MAX_VALUE; n *= 2, r++) {
				if (r == 11)
					break;

				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					c += unknown(n);
				}
				t2 = System.currentTimeMillis();

				pw.println(t2 - t1);
				System.out.println(c + "**n=" + n + "**TIME=" + (t2 - t1) + "**nTimes=" + nTimes);
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