package session4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SalesmanTest {

	@Test
	public void testCaseGraph1Greedy1() {
		String file = "src/main/java/session4/graph1.txt";
		int[] expected = {0, 1, 2, 3, 0};
		int expectedCost = 10;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph1Greedy2() {
//		String file = "src/main/java/session4/graph1.txt";
//		int[] expected = {0, 1, 2, 3, 0};
//		int expectedCost = 10;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}

	@Test
	public void testCaseGraph2Greedy1() {
		String file = "src/main/java/session4/graph2.txt";
		int[] expected = {0, 1, 2, 4, 3, 5, 0};
		int expectedCost = 58;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph2Greeady2() {
//		String file = "src/main/java/session4/graph2.txt";
//		int[] expected = {0, 1, 2, 4, 3, 5, 0};
//		int expectedCost = 58;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
	@Test
	public void testCaseGraph3Greedy1() {
		String file = "src/main/java/session4/graph3.txt";
		int[] expected = {0, 1, 2, 3, 4, 5, 0};
		int expectedCost = 50;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph3Greeady2() {
//		String file = "src/main/java/session4/graph3.txt";
//		int[] expected = {0, 1, 2, 3, 4, 5, 0};
//		int expectedCost = 50;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
	@Test
	public void testCaseGraph4Greedy1() {
		String file = "src/main/java/session4/graph4.txt";
		int[] expected = {0, 2, 4, 5, 3, 6, 1, 0};
		int expectedCost = 121;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph4Greeady2() {
//		String file = "src/main/java/session4/graph4.txt";
//		int[] expected = {0, 2, 4, 1, 6, 3, 5, 0};
//		int expectedCost = 111;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
	@Test
	public void testCaseGraph5Greedy1() {
		String file = "src/main/java/session4/graph5.txt";
		int[] expected = {0, 5, 2, 6, 4, 7, 9, 1, 8, 3, 0};
		int expectedCost = 230;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph5Greeady2() {
//		String file = "src/main/java/session4/graph5.txt";
//		int[] expected = {0, 3, 9, 7, 4, 8, 1, 6, 2, 5, 0};
//		int expectedCost = 179;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
	@Test
	public void testCaseGraph6Greedy1() {
		String file = "src/main/java/session4/graph6.txt";
		int[] expected = {0, 9, 8, 3, 2, 4, 1, 5, 6, 7, 0};
		int expectedCost = 237;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph6Greeady2() {
//		String file = "src/main/java/session4/graph6.txt";
//		int[] expected = {0, 1, 4, 2, 3, 8, 6, 5, 7, 9, 0};
//		int expectedCost = 133;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
	@Test
	public void testCaseGraph7Greedy1() {
		String file = "src/main/java/session4/graph7.txt";
		int[] expected = {0, 1, 2, 3, 4, 7, 6, 8, 5, 9, 0};
		int expectedCost = 257;
    	Salesman v = new Salesman(file);
    	int cost = v.greedy1(0);
    	
    	assertEquals(expectedCost, cost);
    	assertArrayEquals(expected, v.getSol());
	}

//	@Test
//	public void testCaseGraph7Greeady2() {
//		String file = "src/main/java/session4/graph7.txt";
//		int[] expected = {0, 1, 2, 3, 4, 7, 5, 8, 6, 9, 0};
//		int expectedCost = 280;
//    	Salesman v = new Salesman(file);
//    	int cost = v.greedy2();
//    	
//    	assertEquals(expectedCost, cost);
//    	assertArrayEquals(expected, v.getSol());
//	}
	
}
