package session2.check;

import java.io.FileWriter;
import java.io.PrintWriter;

import session2.Bubble;
import session2.Insertion;
import session2.QuicksortCentralElement;
import session2.QuicksortFateful;
import session2.QuicksortMedianOfThree;
import session2.Selection;
import session2.Vector;

public class SortingMeasurements {
	private static int differentSizes = 15; // how many sizes do you want to use in the measurements
	private static int nTimes = 1; // number of repetitions of the executions
	private static String option = "random";

	/**
	 * This program could be used to test all the sorting algorithms
	 */
	public static void main(String arg[]) {
		int[] it = new int[differentSizes];
		int i = 0;
		for (int size = 10000; size <= Integer.MAX_VALUE && i < it.length; size *= 2) {
			it[i] = size;
			i++;
		}
		int n = it[0];
		System.out.println("Different sizes = " + i);

		measureTimes(new Insertion(n), it, "Insertion");

		measureTimes(new Selection(n), it, "Selection");

		measureTimes(new Bubble(n), it, "Bubble");

		measureTimes(new QuicksortFateful(n), it, "QuicksortFateful");

		measureTimes(new QuicksortCentralElement(n), it, "QuicksortCentralElement");

		measureTimes(new QuicksortMedianOfThree(n), it, "QuicksortMedianOfThree");
	}

	public static void measureTimes(Vector v, int[] iterations, String filename) {
		long t1, t2;
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter(filename + "-" +option + ".txt");
			pw = new PrintWriter(file);

			System.out.println("\n\nTime Measurement: " + v.getName());
			for (int n : iterations) {
				v.inicialize(n);
				if (option.compareTo("sorted") == 0)
					v.directlySorted();
				else if (option.compareTo("inverse") == 0)
					v.inverselySorted();
				else
					v.randomlySorted();

				t1 = System.currentTimeMillis();
				for (int repetitions = 1; repetitions <= nTimes; repetitions++) {
					v.sort();
				}
				t2 = System.currentTimeMillis();
				
				pw.println(t2-t1);
				System.out.println("n=" + n + "**TIME=" + (t2 - t1));
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
