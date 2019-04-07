package com.xwd.test;

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

	public static void test(int i) {
		System.out.println(i);
		if (i == 10) {
			return;
		}
		System.out.println((int)'4');
//		for (int j = 0; j < 2; j++) {
//			test(++i);
//		}
	}

	public static void main(String[] args) throws InterruptedException {
		int i = 3;
		ThreadUnsafeExample.test(i);
//		final int threadSize = 1000;
//		ThreadUnsafeExample example = new ThreadUnsafeExample();
//		final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for (int i = 0; i < threadSize; i++) {
//			executorService.execute(() -> {
//				example.add();
//				countDownLatch.countDown();
//			});
//		}
//		countDownLatch.await();
//		executorService.shutdown();
//		System.out.println(example.get());
	}
}
