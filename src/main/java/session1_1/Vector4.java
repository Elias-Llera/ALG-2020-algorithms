package session1_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Vector4 {

	final static int MAX_REP = 13;
	
	public static void main(String[] args) {
		// int nTimes = Integer.parseInt(args[0]);
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
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("fillIn.txt");
			pw = new PrintWriter(file);
			
			for (int i = 10, r = 0; i < Integer.MAX_VALUE; i *= 3, r++) {
				if (r == MAX_REP) break;
				
				int[] v = new int[i];
				long t1, t2;
				
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					Vector1.fillIn(v);
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2 - t1);
				System.out.println(String.format("FILL IN MEASURE:: SIZE = %d ** TIME = %d ms", i, t2 - t1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void measureSum(int nTimes) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("Sum.txt");
			pw = new PrintWriter(file);
			
			for (int i = 10, r =0; i < Integer.MAX_VALUE; i *= 3, r++) {
				if(r==20) break;
				
				int[] v = new int[i];
				Vector1.fillIn(v);
				long t1, t2;
				int s = 0;
				
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					s = Vector1.sum(v);
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2 - t1);
				System.out.println(
						String.format("SUM MEASURE:: SIZE = %d ** TIME = %d ms and the sum is %d", i, t2 - t1, s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void measureMaximum(int nTimes) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("Maximum.txt");
			pw = new PrintWriter(file);
			
			for (int i = 10, r = 0; i < Integer.MAX_VALUE; i *= 3, r++) {
				if (r == 20) break;
				
				int[] v = new int[i];
				Vector1.fillIn(v);
				long t1, t2;
				int[] s = new int[2];
				
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					Vector1.maximum(v, s);
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2-t1);
				System.out.println(
						String.format("MAXIMUM MEASURE:: SIZE = %d ** TIME = %d ms and the maximum is [%d, %d]", i,
								t2 - t1, s[0], s[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}
