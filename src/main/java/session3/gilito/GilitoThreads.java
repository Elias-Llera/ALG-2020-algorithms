package session3.gilito;

/**
 * This class simulates the algorithm currently used by TIO GILITO and
 * challenges us to improve it for free (the usurer does not plan to pay us
 * anything)
 */
public class GilitoThreads {
	private int[] coins; // weight in grams of the n coins
	private long watts; // average energy consumed (watts)
	public static int REAL_WEIGHT = 1000;
	public static int FAKE_WEIGHT = 999;

	public GilitoThreads(int n) {
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
		int weightRight, weightLeft;
		MyThread threadL, threadR;
		if ((r - l + 1) % 2 == 0) { //number of coins is even
			threadL = new MyThread(l, mid);
			threadR = new MyThread(mid+1, r);
			threadL.start();
			threadR.start();
			try {
				threadL.join();
				threadR.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			weightRight = threadL.getWeight(); 
			weightLeft = threadR.getWeight();
		}
		else { //number of coins is odd
			threadL = new MyThread(l, mid);
			threadR = new MyThread(mid, r);
			threadL.start();
			threadR.start();
			try {
				threadL.join();
				threadR.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			weightRight = threadL.getWeight(); 
			weightLeft = threadR.getWeight();
		}

		if (weightLeft > weightRight) {		//fake coin is in first half
			if (l + 1 == r) { //if there is only one or two coins, we finished
				return l;
			} else {
				return calculateRec(l, mid); //weight first half now
			}

		} else if (weightLeft < weightRight)	//fake coin is in the second half
			if (l + 1 == r) {	//if there is only one or two coins, we finished
				return r;
			} else {
				return calculateRec(mid + 1, r); //weight second half now
			}

		else // balance == 3 
			return mid;	//fake coin is in the shared coin between two halves (middle one)
	}

	public static void main(String arg[]) {
		// int n = Integer.parseInt(arg[0]); // number of coins (size of the problem)
		int n = 10;
		GilitoThreads gilito = new GilitoThreads(n);

		// let's simulate the n possible cases - false currency in each position
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				gilito.setCoinWeight(j, REAL_WEIGHT); // authentic coin weight
			gilito.setCoinWeight(i, FAKE_WEIGHT); // fake coin weight
			gilito.calculate();
		}
		System.out.println("COINS=" + n + " ***AVERAGE ENERGY=" + gilito.getUsedWatts() / n + " watts");
	}

	
	class MyThread extends Thread{
		private int l, r, weight;
		public MyThread(int l, int r) {
			this.l = l;
			this.r = r;
			}
		@Override
		public void run() {
			balance();
		}
		public void balance() {
			watts++; // 1 watts used

			int weight = 0; // weight of left plate
			for (int i = l; i <= r; i++)
				weight += coins[i];

			this.weight = weight;
		}
		public int getWeight() {
			return weight;
		}
	}
}