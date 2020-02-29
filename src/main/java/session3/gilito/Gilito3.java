package session3.gilito;

/**
 * This class simulates the algorithm currently used by TIO GILITO and
 * challenges us to improve it for free (the usurer does not plan to pay us
 * anything)
 */
public class Gilito3 {
	private int[] coins; // weight in grams of the n coins
	private long watts; // average energy consumed (watts)
	public static int REAL_WEIGHT = 1000;
	public static int FAKE_WEIGHT = 999;

	public Gilito3(int n) {
		this.coins = new int[n];
	}

	public void setCoinWeight(int position, int value) {
		this.coins[position] = value;
	}

	public long getUsedWatts() {
		return this.watts;
	}

	public void resetUsedWatts() {
		this.watts = 0;
	}

	/**
	 * Weigh the coins of the left plate between the leftMin and leftMax positions
	 * Weigh the coins of the right plate between the rightMin and righMax positions
	 * 
	 * @return 1 if left side is less heavy, 2 if right side is less heavy and 3 if
	 *         they weigh the same
	 */
	public int balance(int leftMin, int leftMax, int rightMin, int rightMax) {
		watts++; // 1 watts used

		int leftWeight = 0; // weight of left plate
		int nCoinsL = leftMax - leftMin + 1;
		int nCoinsR = rightMax - rightMin + 1;
		for (int i = leftMin; i <= leftMax; i++)
			leftWeight += this.coins[i];

		int rightWeight = 0; // weight of right plate
		for (int i = rightMin; i <= rightMax; i++)
			rightWeight += this.coins[i];

		if (leftWeight < nCoinsL * REAL_WEIGHT)
			return 1;
		if (rightWeight < nCoinsR * REAL_WEIGHT)
			return 2;
		return 3;
	}

	/**
	 * Improved algorithm
	 * 
	 * @return position of the fake coin Best case: the fake coin is one of the two
	 *         first coins (1 watt used) Worst case: the fake coin is the last one
	 *         (n/2 watts used approximately) Average case: average of all the
	 *         positions (n/4 watts used approximately) This algorithm is linear
	 *         (O(n)) in the worst and average cases
	 */
	public int calculate() {
		return calculateRec(0, coins.length - 1);
	}

	private int calculateRec(int l, int r) {
		int mid = (l + r) / 2;
		int balance = balance(l, mid, mid + 1, r);

		if (balance == 1) {
			if (l + 1 == r) {
				return l;
			} else {
				return calculateRec(l, mid);
			}

		} else if (balance == 2)
			if (l + 1 == r) {
				return r;
			} else {
				return calculateRec(mid + 1, r);
			}

		else // balance == 3
			throw new RuntimeException();
	}

	public static void main(String arg[]) {
		// int n = Integer.parseInt(arg[0]); // number of coins (size of the problem)
		int n = 5;
		Gilito3 gilito = new Gilito3(n);

		// let's simulate the n possible cases - false currency in each position
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				gilito.setCoinWeight(j, REAL_WEIGHT); // authentic coin weight
			gilito.setCoinWeight(i, FAKE_WEIGHT); // fake coin weight
			gilito.calculate();
		}
		System.out.println("COINS=" + n + " ***AVERAGE ENERGY=" + gilito.getUsedWatts() / n + " watts");
	}

}