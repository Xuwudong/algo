package com.xwd.heaps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

import com.xwd.heaps.Heap;

/***
 * 数据结构 ：堆;数组第一个元素不存储数据 堆中的元素个数：count; count = arr.length-1
 * 
 * @author admin
 *
 */
public class HeapTest {
	@Test
	public void testBuildHeap() throws Exception {

		Heap<Integer> heap = new Heap<>(15, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}

		});
		for (int i = 0; i < 10; i++) {
			heap.insert(i);
		}
		Object[] arr = heap.getArr();
		assertTrue(10 == heap.getCount());
		assertEquals(9, (int) arr[1]);
		assertEquals(null, arr[0]);
		for (int i = 9; i >= 0; i--) {
			int first = (int) heap.deleteFirst();
			assertTrue(first == i);
		}
		assertTrue(0 == heap.getCount());
	}
}
