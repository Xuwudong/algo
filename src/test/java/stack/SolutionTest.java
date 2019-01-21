package stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	private Solution sol = new Solution();

	@Test
	public void testCalPoints() {
		assertEquals(sol.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }), 27);
	}

	@Test
	public void testCalulate_8() {
		assertEquals(sol.calculate_8("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"), 23);
		assertEquals(sol.calculate_8("(9-(0-(8-(2))))"), 15);
		assertEquals(sol.calculate_8("1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"),
				-15);
	}
}
