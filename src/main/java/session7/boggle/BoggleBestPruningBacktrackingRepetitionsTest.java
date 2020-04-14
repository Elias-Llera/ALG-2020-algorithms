package session7.boggle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoggleBestPruningBacktrackingRepetitionsTest {
	@Test
	public void testCase01() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table01.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 1;
		int numberOfTimesACellCanBeRepeated = 1;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); //The input needs the dictionary and the board files
    	
    	problem.printTable(); //To print the board game
    	problem.findSolutions(); //To execute the main algorithm (backtracking in this case)
    	problem.printSolutions(); //To print the list of words sorted alphabetically in ascending order

    	assertEquals("", problem.getBestSolution());
	}
	
	@Test
	public void testCase02() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table02.txt";

		int numberOfTimesAWordCanBeConcanetaded = 1;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(8, problem.getTotalPoints());
	}
	
	@Test
	public void testCase03() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table03.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 1;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(8, problem.getTotalPoints());
	}
	
	@Test
	public void testCase04() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table04.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(24, problem.getTotalPoints());
	}
	
	@Test
	public void testCase05() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table05.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 3;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(364, problem.getTotalPoints());
	}
	
	@Test
	public void testCase15() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table15.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 10;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
	    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();  	

    	assertEquals(747, problem.getTotalPoints());
	}
	
	@Test
	public void testCase46() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table46.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
	    
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(80, problem.getTotalPoints());
	}
	
	@Test
	public void testCase100() {
		String dictionaryFileName = "src/session7/boggle/dictionary100.txt";
		String tableFileName = "src/session7/boggle/table100.txt";
		
		int numberOfTimesAWordCanBeConcanetaded = 4;
		int numberOfTimesACellCanBeRepeated = 3;	
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
	     	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();   	

    	assertEquals(272, problem.getTotalPoints());
	}
	
	@Test
	public void testCase205() {
		String dictionaryFileName = "src/session7/boggle/dictionary100.txt";
		String tableFileName = "src/session7/boggle/table205.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 4;
		int numberOfTimesACellCanBeRepeated = 3;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
	       	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(272, problem.getTotalPoints());
	}
	
	@Test
	public void testCase205_2() {
		String dictionaryFileName = "src/session7/boggle/dictionary80368.txt";
		String tableFileName = "src/session7/boggle/table205.txt";
				
		int numberOfTimesAWordCanBeConcanetaded = 2;
		int numberOfTimesACellCanBeRepeated = 2;
		BoggleBestPruningBacktrackingRepetitions problem = new BoggleBestPruningBacktrackingRepetitions(dictionaryFileName, numberOfTimesAWordCanBeConcanetaded, numberOfTimesACellCanBeRepeated, tableFileName); 
	    	
    	problem.printTable();
    	problem.findSolutions();
    	problem.printSolutions();

    	assertEquals(80, problem.getTotalPoints());
	}
}
