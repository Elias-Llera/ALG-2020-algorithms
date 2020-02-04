package session1_1;

public class Vector3 {

	public static void main (String[] args) {
		for (int i = 10; i<Integer.MAX_VALUE; i*=5) {
			int[] v = new int[i];
			Vector1.fillIn(v);
			
			long t1, t2;
			t1 = System.currentTimeMillis();
			int s = Vector1.sum(v);
			t2 = System.currentTimeMillis();
			
			System.out.println(String.format("SIZE = %d ** TIME = %d ms and the sum is %d", i, t2-t1, s));
		}
		
	}
	
}
