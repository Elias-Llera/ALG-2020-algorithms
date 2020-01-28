package session0;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MathTest {
	
	Math math;

	@Before
	public void initialize() {
		math = new Math();
	}

	@Test
	public void test2Plus3Equals5() {
		assertEquals(5, math.sum(2, 3));
	}
}
