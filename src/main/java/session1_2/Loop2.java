package session1_2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Loop2 {

	public static void loop2(int n) {
		Random rn = new Random();
		@SuppressWarnings("unused")
		int cont=0;
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++) 
				cont += rn.nextInt();
	}
	
	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("");
			pw = new PrintWriter(file);
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
		for (int n=1; n<=Integer.MAX_VALUE; n*=2) {
			t1 = System.currentTimeMillis();
			
			for (int repetitions=1; repetitions<=nTimes; repetitions++){
				loop2(n);
			}
			
			t2 = System.currentTimeMillis();
			System.out.println ("n="+n+ "**TIME=" +(t2-t1)+ " ** nTimes=" + nTimes);
		} //for	
	} //main
	
} //class