package session1_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	public static int[][] loadMatrix(String fileName) {

		String line;
		int[][] matrix = new int[0][0];

		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			int size = Integer.parseInt(file.readLine());
			matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				line = file.readLine();
				matrix[i] = toVector(line.split("\t"));
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		return matrix;
	}

	private static int[] toVector(String[] line) {
		int[] row = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			row[i] = Integer.parseInt(line[i]);
		}
		return null;
	}
}
