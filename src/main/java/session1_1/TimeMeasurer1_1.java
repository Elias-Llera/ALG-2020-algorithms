package session1_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TimeMeasurer1_1 {
	
	public static void main(String[] args) {
		int nTimes = 500;
		try {
			measureDiagonal1(nTimes);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
//		try {
//			measureDiagonal2(nTimes);
//		} catch (OutOfMemoryError e) {
//			e.printStackTrace();
//		}
	}
	
	private static void measureDiagonal1(int nTimes) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("Diagonal1.txt");
			pw = new PrintWriter(file);
			
			for (int i = 10, r = 0; i < Integer.MAX_VALUE; i *= 3, r++) {
				if (r == 10) break;
				
				MatrixOperations mo = new MatrixOperations(i);
				long t1, t2;
				
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					mo.sumDiagonal1();
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2 - t1);
				System.out.println(String.format("SumDiagonal1:: SIZE = %d ** TIME = %d ms", i, t2 - t1));
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
	
	private static void measureDiagonal2(int nTimes) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("Diagonal2.txt");
			pw = new PrintWriter(file);
			
			for (int i = 10, r = 0; i < Integer.MAX_VALUE; i *= 3, r++) {
				if (r == 10) break;
				
				MatrixOperations mo = new MatrixOperations(i);
				long t1, t2;
				
				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					mo.sumDiagonal2();
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2 - t1);
				System.out.println(String.format("SumDiagonal2:: SIZE = %d ** TIME = %d ms", i, t2 - t1));
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
	
}
