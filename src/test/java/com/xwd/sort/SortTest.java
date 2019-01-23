package com.xwd.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xwd.sort.Sort;

public class SortTest {
	private static Sort sort;
	private int[] arr;

	@BeforeClass
	public static void init() {
		sort = new Sort();
	}

	@Before
	public void initArr() {
		arr = new int[] { 1, 3, 5, 3, 6, 2, 90, 34, 54 };
	}

	@Test
	public void testQuickSor() {
		sort.quickSort(arr);
		print(arr);
		assertEquals(90, arr[arr.length - 1]);
		assertEquals(1, arr[0]);
//        new Sort().mergeSort(arr);
//        new Sort().insertSort(arr);
	}

	@Test
	public void testMergeSort() {
		initArr();
		sort.mergeSort(arr);
		print(arr);
		assertEquals(90, arr[arr.length - 1]);
		assertEquals(1, arr[0]);
	}

	@Test
	public void testInsertSort() {
		initArr();
		sort.insertSort(arr);
		print(arr);
		assertEquals(90, arr[arr.length - 1]);
		assertEquals(1, arr[0]);
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}
}
