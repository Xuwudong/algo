package binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	private int[] arr = { 1, 2, 3, 6, 7, 7, 7, 7, 8, 9, 10 };
	/** 循环数组 **/
	private int[] arr2 = { 4, 5, 6, 1, 2, 3 };
	private Solution sol;

	@Before
	public void init() {
		this.sol = new Solution();
	}

	@Test
	public void testGetFirstEle() {
		int index = sol.getFirstEle(arr, 7);
		assertEquals(index, 4);
	}

	@Test
	public void testGetLastEle() {
		int index = sol.getLastEle(arr, 7);
		assertEquals(index, 7);
	}

	@Test
	public void testFirstGteEle() {
		int index = sol.getFirstGteEle(arr, 5);
		assertEquals(index, 3);
	}

	@Test
	public void testFirstLteEle() {
		int index = sol.getFirstLteEle(arr, 8);
		assertEquals(index, 8);
		index = sol.getFirstLteEle(arr, 5);
		assertEquals(index, 2);
		index = sol.getFirstLteEle(arr, 11);
		assertEquals(index, 10);
	}

	@Test
	public void testBinarySearchCircle() {
		for (int i = 1; i < 7; i++) {
			assertEquals(sol.binarySearchCircle(arr2, i), (i + 2) % 6);
		}
	}

	@Test
	public void testSearch() {
		for (int i = 1; i < 7; i++) {
			assertEquals(sol.search(arr2, i), (i + 2) % 6);
		}
	}

}
