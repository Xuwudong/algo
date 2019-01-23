package com.xwd.heaps.top10;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.xwd.heaps.top10.Top10;

public class Top10Test {
	@Test
	public void top10Test() throws IOException, InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		heaps.top10.Top10 top10 = new heaps.top10.Top10();
		File bigFile = top10.init();
		top10.top10(bigFile);
		long end = System.currentTimeMillis();
		top10.getFinalHeap().print();
		top10.getFinalHeap().heapSort();
		top10.getFinalHeap().print();
		System.out.println("spend time:" + (end - start) + "ms");
	}
}