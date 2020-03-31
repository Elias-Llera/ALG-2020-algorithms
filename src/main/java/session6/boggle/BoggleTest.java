package session6.boggle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoggleTest {
	@Test
	public void testCase01() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table01.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName); //The input needs the dictionary and the board files
    	
    	problem.printTable(); //To print the board game
    	problem.findSolutions(); //To execute the main algorithm (backtracking in this case)
    	problem.printSolutions(); //To print the list of words sorted alphabetically in ascending order
    	
    	assertEquals(0, problem.getSolutions().size()); //In this case, there are no solutions
    	assertEquals(0, problem.getTotalPoints()); //So, total points should be 0
	}
	
	@Test
	public void testCase02() {
		String dictionaryFileName = "src/main/java/labs/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table02.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(12, problem.getSolutions().size());
    	assertEquals("ups", problem.getSolutions().get(10)); //Since solutions are sorted, we should be sure that in position 10 the word is "ups"
    	assertEquals(19, problem.getTotalPoints());
	}
	
	@Test
	public void testCase03() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table03.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(32, problem.getSolutions().size());
    	assertEquals("sum", problem.getSolutions().get(28));
    	assertEquals(84, problem.getTotalPoints());
	}
	
	@Test
	public void testCase04() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table04.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(65, problem.getSolutions().size());
    	assertEquals("tog", problem.getSolutions().get(61));
    	assertEquals(160, problem.getTotalPoints());
	}
	
	@Test
	public void testCase05() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table05.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(173, problem.getSolutions().size());
    	assertEquals("thou", problem.getSolutions().get(157));
    	assertEquals(682, problem.getTotalPoints());
	}
	
	@Test
	public void testCase15() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table15.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(957, problem.getSolutions().size());
    	assertEquals("zee", problem.getSolutions().get(953));
    	assertEquals(4006, problem.getTotalPoints());
	}
	
	@Test
	public void testCase46() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
		String tableFileName = "src/main/java/session6/boggle/table46.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(6777, problem.getSolutions().size());
    	assertEquals("zetas", problem.getSolutions().get(6749));
    	assertEquals(40802, problem.getTotalPoints());
	}
	
	@Test
	public void testCase100() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary100.txt";
		String tableFileName = "src/main/java/session6/boggle/table100.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(91, problem.getSolutions().size());
    	assertEquals("your", problem.getSolutions().get(90));
    	assertEquals(314, problem.getTotalPoints());
	}
	
	@Test
	public void testCase205() {
		String dictionaryFileName = "src/main/java/session6/boggle/dictionary100.txt";
		String tableFileName = "src/main/java/session6/boggle/table205.txt";
				
    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(96, problem.getSolutions().size());
    	assertEquals("your", problem.getSolutions().get(95));
    	assertEquals(349, problem.getTotalPoints());
	}
	
//	@Test
//	public void testCase205_2() {
//		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
//		String tableFileName = "src/main/java/session6/boggle/table205.txt";
//				
//    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
//    	
//    	problem.printTable();
//    	problem.findSolutions();
//    	problem.printSolutions();
//    	
//    	assertEquals(32650, problem.getSolutions().size());
//    	assertEquals("zorils", problem.getSolutions().get(32631));
//    	assertEquals(282921, problem.getTotalPoints());
//	}
//	
//	
//	@Test
//	public void testCase500() {
//		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
//		String tableFileName = "src/main/java/session6/boggle/table500.txt";
//				
//    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
//    	
//    	problem.printTable();
//    	problem.findSolutions();
//    	problem.printSolutions();
//    	
//    	assertEquals(58368, problem.getSolutions().size());
//    	assertEquals("zymase", problem.getSolutions().get(58355));
//    	assertEquals(603192, problem.getTotalPoints());
//	}
//	
//	@Test
//	public void testCase1000() {
//		String dictionaryFileName = "src/main/java/session6/boggle/dictionary80368.txt";
//		String tableFileName = "src/main/java/session6/boggle/table1000.txt";
//				
//    	Boggle problem = new Boggle(dictionaryFileName, tableFileName);
//    	
//    	problem.printTable();
//    	problem.findSolutions();
//    	problem.printSolutions();
//    	
//    	assertEquals(75141, problem.getSolutions().size());
//    	assertEquals("zymosis", problem.getSolutions().get(75136));
//    	assertEquals(844340, problem.getTotalPoints());
//	}
}