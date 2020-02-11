package session1_2;

import util.TimeTaker;

public class TimeMeasurer1_2 {

	public static void main(String[] args) {
		TimeTaker.test("session1_2.Loop1", "loop1", 3, startN, endN, params);
		TimeTaker.test("session1_2.Loop2", "loop2", 3, startN, endN, params);
		TimeTaker.test("session1_2.Loop3", "loop3", 3, startN, endN, params);
		TimeTaker.test("session1_2.Unknown", "unknown", 3, startN, endN, params);
	}
	
}
