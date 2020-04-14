package session7.boggle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoggleAllBacktrackingRepetitionsTest {
	@Test
	public void testCase01() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table01.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); //The input needs the dictionary and the board files
    	
    	problem.printTable(); //To print the board game
    	problem.findSolutions(); //To execute the main algorithm (backtracking in this case)
    	problem.printSolutions(); //To print the list of words sorted alphabetically in ascending order
    	
    	assertEquals(0, problem.getSolutions().size()); //In this case, there are no solutions
    	assertEquals(0, problem.getTotalPoints()); //So, total points should be 0
	}
	
	@Test
	public void testCase02() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table02.txt";

		int numberOfTimesAWordCanBeConcanetaded = 3;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	   	
    	assertEquals(20, problem.getSolutions().size());
    	assertEquals("puspuspus", problem.getSolutions().get(10)); //Since solutions are sorted, we should be sure that in position 10 the word is "ups"
    	assertEquals(260, problem.getTotalPoints());
	}
	
	@Test
	public void testCase03() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "ssrc/session7/boggle/table03.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 10;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(46, problem.getSolutions().size());
    	assertEquals("mmmm", problem.getSolutions().get(28));
    	assertEquals(461, problem.getTotalPoints());
	}
	
	@Test
	public void testCase04() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table04.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 1;
		int numberOfTimesACellCanBeRepeated = 1;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	   	
    	assertEquals(65, problem.getSolutions().size());
    	assertEquals("tog", problem.getSolutions().get(61));
    	assertEquals(384, problem.getTotalPoints());
	}
	
	@Test
	public void testCase05() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table05.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 100;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	    	
    	assertEquals(240, problem.getSolutions().size());
    	assertEquals("mog", problem.getSolutions().get(157));
    	assertEquals(2511, problem.getTotalPoints());
	}
	
	@Test
	public void testCase15() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table15.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(1268, problem.getSolutions().size());
    	assertEquals("sag", problem.getSolutions().get(953));
    	assertEquals(14119, problem.getTotalPoints());
	}
	
	@Test
	public void testCase46() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table46.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 5;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(9092, problem.getSolutions().size());
    	assertEquals("rickrick", problem.getSolutions().get(6749));
    	assertEquals(129135, problem.getTotalPoints());
	}
	
	@Test
	public void testCase100() {
		String dictionaryFileName = "src/session7/boggle/dictionary100.txt";
		String tableFileName = "src/session7/boggle/table100.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 200;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
        	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(94, problem.getSolutions().size());
    	assertEquals("withwith", problem.getSolutions().get(90));
    	assertEquals(2228, problem.getTotalPoints());
	}
	
	@Test
	public void testCase205() {
		String dictionaryFileName = "src/session7/boggle/dictionary100.txt";
		String tableFileName = "src/session7/boggle/table205.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
        	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(97, problem.getSolutions().size());
    	assertEquals("youryour", problem.getSolutions().get(95));
    	assertEquals(1786, problem.getTotalPoints());
	}
	
	@Test
	public void testCase205_2() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table205.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleAllBacktrackingRepetitions problem = new BoggleAllBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();
    	
    	assertEquals(41915, problem.getSolutions().size());
    	assertEquals("shills", problem.getSolutions().get(32631));
    	assertEquals(822327, problem.getTotalPoints());
	}
}
