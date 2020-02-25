package session3.gilito;

/**
 * This class simulates the algorithm currently used by TIO GILITO 
 * and challenges us to improve it for free (the usurer 
 * does not plan to pay us anything)
 */
public class Gilito1 {
	private int []coins;  //weight in grams of the n coins
	private long watts;    //average energy consumed (watts)
	public static int REAL_WEIGHT = 1000;
	public static int FAKE_WEIGHT = 999;

	public Gilito1(int n) {
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
	 * @return 1 if left side is less heavy, 2 if right side is less heavy and 3 if they weigh the same
	 */
	public int balance(int leftMin, int leftMax, int rightMin, int rightMax) {  
		watts++;  //1 watts used  
		
		int leftWeight = 0;      //weight of left plate
		for (int i=leftMin; i<=leftMax; i++)
			leftWeight += this.coins[i];
		
		int rightWeight = 0;     //weight of right plate 
		for (int i=rightMin; i<=rightMax; i++)
			rightWeight += this.coins[i];
	
		if (leftWeight < rightWeight) return 1; 
		if (leftWeight > rightWeight) return 2;
		return 3;
	}

	/**
	 * Current algorithm, which we are asked to improve
	 * @return position of the fake coin
	 * Best case: the fake coin is one of the two first coins (1 watt used)
	 * Worst case: the fake coin is the last one (n/2 watts used approximately)
	 * Average case: average of all the positions (n/4 watts used approximately)
	 * This algorithm is linear (O(n)) in the worst and average cases
	 */	
	public int calculate() {
		int res = 0;
		for (int i=0; i<this.coins.length/2; i++) {
		   res = balance(2*i, 2*i, 2*i+1, 2*i+1); //just one coin to the left and one coin to the right side
		   if (res == 1) return 2*i; //fake coin is the left coin
		   else if (res == 2) return 2*i+1; //fake coin is the right coin
		}
		return (this.coins.length - 1); //just in case n is odd and fake coin is the last one  
	}
	
	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //number of coins (size of the problem)
		Gilito1 gilito = new Gilito1(n);

		//let's simulate the n possible cases - false currency in each position
		for (int i=0; i<n; i++) { 
		    for (int j=0; j<n; j++) 
		    	gilito.setCoinWeight(j, REAL_WEIGHT); //authentic coin weight	    
		    gilito.setCoinWeight(i, FAKE_WEIGHT); //fake coin weight
		    gilito.calculate();
		}
		System.out.println("COINS="+n+" ***AVERAGE ENERGY="+ gilito.getUsedWatts()/n +" watts");
	} 
}