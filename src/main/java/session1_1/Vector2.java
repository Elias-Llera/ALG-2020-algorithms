package session1_1;

public class Vector2 {

	public static void main (String[] args) {
		//int n = Integer.parseInt(args[0]);
		int n = 200000000;
		int[] v = new int[n];
		Vector1.fillIn(v);
		
		long t1, t2;
		t1 = System.currentTimeMillis();
		int s = Vector1.sum(v);
		t2 = System.currentTimeMillis();
		
		System.out.println(String.format("SIZE = %d ** TIME = %d ms and the sum is %d", n, t2-t1, s));
	}
}
