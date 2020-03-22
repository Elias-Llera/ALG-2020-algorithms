package session5.check;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import session5.Exchange;

public class ExchangeTest {

	@Test
	public void testCase01() {
		String file = "src/main/java/session5/check/case01.txt";
		int[] expectedBestCoins = {1, 2, 1};
		int expectedNumCoins = 4;
    	Exchange c1 = new Exchange(file);
    	int numCoins = c1.getNumCoins(15);
    	
    	assertEquals(expectedNumCoins, numCoins);
    	assertArrayEquals(expectedBestCoins, c1.getBestCoins());
	}

	@Test
	public void testCase02() {
		String file = "src/main/java/session5/check/case02.txt";
		int[] expectedBestCoins = {0, 0, 3, 0, 0, 0};
		int expectedNumCoins = 3;
    	Exchange c1 = new Exchange(file);
    	int numCoins = c1.getNumCoins(60);
    	
    	assertEquals(expectedNumCoins, numCoins);
    	assertArrayEquals(expectedBestCoins, c1.getBestCoins());
	}

	@Test
	public void testCase03() {
		String file = "src/main/java/session5/check/case03.txt";
		int[] expectedBestCoins = {0, 0, 3, 0, 0, 0, 0, 0};
		int expectedNumCoins = 3;
    	Exchange c1 = new Exchange(file);
    	int numCoins = c1.getNumCoins(15);
    	
    	assertEquals(expectedNumCoins, numCoins);
    	assertArrayEquals(expectedBestCoins, c1.getBestCoins());
	}

	@Test
	public void testCase04() {
		String file = "src/main/java/session5/check/case04.txt";
		int[] expectedBestCoins = {2, 0, 2};
		int expectedNumCoins = 4;
    	Exchange c1 = new Exchange(file);
    	int numCoins = c1.getNumCoins(14);
    	
    	assertEquals(expectedNumCoins, numCoins);
    	assertArrayEquals(expectedBestCoins, c1.getBestCoins());
	}

//	@Test
//	public void testCase05() {
//		String file = "src/main/java/session5/check/case05.txt";
//		int[] expectedBestCoins = {0, 2, 1, 1, 1, 1, 0, 1};
//		int expectedNumCoins = 7;
//    	Exchange c1 = new Exchange(file);
//    	int numCoins = c1.getNumCoins(289);
//    	
//    	assertEquals(expectedNumCoins, numCoins);
//    	assertArrayEquals(expectedBestCoins, c1.getBestCoins());
//	}

}
