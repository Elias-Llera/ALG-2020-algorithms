package session7.pyramid;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

/**
 * JUnit Test for Pyramid Puzzle
 */
public class PyramidPuzzleTest {
	
	@Test
	public void test1() {
		boolean result = executeFromFile("src/main/java/session7/pyramid/case1.txt");
		assertEquals(true, result);
	}
	
	@Test
	public void test2() {
		boolean result = executeFromFile("src/main/java/session7/pyramid/case2.txt");
		assertEquals(true, result);
	}
	
	@Test
	public void test3() {
		boolean result = executeFromFile("src/main/java/session7/pyramid/case3.txt");
		assertEquals(true, result);
	}
	
	@Test
	public void test4() {
		boolean result = executeFromFile("src/main/java/session7/pyramid/case4.txt");
		assertEquals(true, result);
	}
	
	/**
	 * Reads the initial pyramid from a text file and created an object to deal with the problem
	 * @param file File from which 
	 * @return True if we find a solution for the problem, false otherwise
	 */
	private boolean executeFromFile(String file) {
		boolean result = false;
		//input
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			
			//first line (HEIGHT OF THE PYRAMID)
			String size = br.readLine(); //height of the pyramid
			int n = Integer.parseInt(size); //n
			PyramidBoard board = new PyramidBoard(n);
			
			//next lines
			for (int i=0; i<n; i++) {
				String[] values = br.readLine().split(" ");				
				board.insertValues(values, i);
			}
			
			Instant start = Instant.now();
			
			PyramidPuzzle puzzle = new PyramidPuzzle(board);	
			puzzle.branchAndBound(puzzle.getRootNode()); 		
			
			Instant end = Instant.now();
			Duration duration = Duration.between(start, end);
			System.out.println("Time to finish: " + duration.getSeconds() + " seconds");
			
			puzzle.printSolutionTrace();
			
			result = puzzle.getBestNode() != null ? true : false; 
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return result;
	}
	
}
