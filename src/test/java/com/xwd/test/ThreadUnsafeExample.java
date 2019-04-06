package com.xwd.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUnsafeExample {

	private int cnt = 0;
//	private AtomicInteger cnt = new AtomicInteger(0);

	public synchronized void add() {
//		cnt.incrementAndGet();
		cnt++;
	}

	public synchronized int get() {
//		return cnt.get();
		return cnt;
	}

	public static void main(String[] args) throws InterruptedException {
		final int threadSize = 1000;
		ThreadUnsafeExample example = new ThreadUnsafeExample();
		final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < threadSize; i++) {
			executorService.execute(() -> {
				example.add();
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println(example.get());
	}
}
