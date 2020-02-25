package session3.gilito;

public class Gilito1Times {
	public static void main(String arg[]) {
		int nTimes = 10; 
		long t1, t2; 
		int position = 0;
		for (int n=10; n<Integer.MAX_VALUE; n*=2) {
			Gilito1 gilito = new Gilito1(n);
			for (int i=0;i<n;i++)  
				gilito.setCoinWeight(i, Gilito1.REAL_WEIGHT); //authentic coin weight
			gilito.setCoinWeight(n-1, Gilito1.FAKE_WEIGHT);  //worst case (last coin is the fake one)
		  
			t1=System.currentTimeMillis();
			for (int i=0; i<nTimes; i++) 
				position = gilito.calculate();
			t2=System.currentTimeMillis();
			System.out.println(String.format("CLASSIC: NCOINS=%d FAKE_POSITION=%d ENERGY_USED=%d TIME=%d NTIMES=%d", n, position, gilito.getUsedWatts()/nTimes, t2-t1, nTimes));
		}
	}  
}
