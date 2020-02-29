package session3.recursive;

/* Params: a=4;b=2;k=0
 * a > b^k -> 4 > 2^0
 * The time complexity is O(n^2) 
 */
public class Division4 {
	public static long rec4 (int n) {
		long cont = 0;
		if (n<=0) 
			cont++;
		else { 
			cont++ ; // O(1)    
			rec4(n/2);
			rec4(n/2);
			rec4(n/2);
			rec4(n/2);
		}
		return cont;   
	}
	
	public static void main (String arg []) {
		 long t1,t2,cont = 0;	 
		 for (int n=1;n<=10000000;n*=2) {
			  t1 = System.currentTimeMillis ();			   
			  cont = rec4(n);
			  t2 = System.currentTimeMillis ();
			
			  System.out.println ("n="+n+ "**TIME="+(t2-t1)+"**cont="+cont);	
		 }  // for
	} // main
} //class