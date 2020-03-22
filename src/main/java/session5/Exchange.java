package session5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exchange {

	public int coins[], bestCoins[];
	int numCoins[][];
	boolean boolCoins[][];
	int amount;

	public static void main(String arg[]) {
	}

	public Exchange(String fileName) {
		loadFile(fileName);
	}

	public int getNumCoins(int amount) {
		this.amount = amount;
		numCoins = new int[coins.length + 1][amount + 1];
		boolCoins = new boolean[coins.length + 1][amount + 1];
		int min, a, b;

		for (int i = 0; i < numCoins[0].length; i++) {
			numCoins[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < coins.length + 1; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (coins[i - 1] <= j) {
					a = numCoins[i - 1][j];
					b = numCoins[i][j - coins[i - 1]] + 1;
					min = min(a, b);
					if (min == a) {
						numCoins[i][j] = a;
					} else {
						numCoins[i][j] = b;
						boolCoins[i][j] = true;
					}
				} else {
					numCoins[i][j] = numCoins[i - 1][j];
				}
			}
		}
		return numCoins[coins.length][amount];
	}

	public int[] getBestCoins() {
		bestCoins = new int[coins.length];
		int i = coins.length;
		int j = amount;
		while (j > 0) {
			if (boolCoins[i][j]) {
				bestCoins[i - 1] += 1;
				j -= coins[i - 1];
			} else {
				i--;
			}
		}
		return bestCoins;
	}

	private void loadFile(String fileName) {
		BufferedReader file = null;
		String line;
		int nCoins;

		try {
			file = new BufferedReader(new FileReader(fileName));
			line = file.readLine();
			nCoins = Integer.parseInt(line);
			bestCoins = new int[nCoins];
			coins = new int[nCoins];

			line = file.readLine();
			String values[] = line.split("\t");
			for (int i = 0; i < nCoins; i++) {
				coins[i] = Integer.parseInt(values[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("File reading error: " + fileName);
		}
	}

	private int min(int a, int b) {
		if (a > b) {
			return b;
		}
		return a;
	}

}