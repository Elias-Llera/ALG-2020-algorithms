package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class TimeTaker {
	
	final static int SUM = 0;
	final static int MULT = 1;
	final static int POW = 2;
	
	public static void test(String className, String methodName, int samples, int startN, int endN, int ratio, Class<?>[] params) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter(className + "-" + methodName + ".csv");
			pw = new PrintWriter(file);
			for (int n = startN; n <= endN; n++) {
				long totalTime = 0;
				for (int i = 0; i < samples; i++) {
					totalTime += testAlgorithm(className, methodName, params);
				}
				pw.println(totalTime / samples);
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
	
	public static long testAlgorithm(String className, String methodName, Class<?>[] params) throws Exception {
		Object alg = Class.forName(className).newInstance();
		Method m = alg.getClass().getMethod(methodName, params);
		long before = System.currentTimeMillis();
		m.invoke(alg);
		return System.currentTimeMillis() - before;
	}
	
}