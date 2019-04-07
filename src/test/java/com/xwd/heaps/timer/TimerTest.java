package com.xwd.heaps.timer;

import org.junit.Test;


public class TimerTest {

	@Test
	public void timerTest() throws InterruptedException {
		Timer timer = new Timer();
		for (int i = 1000; i < 10000; i += 1000) {
			Task task = new Task(i);
			timer.getTasks().add(task);
			timer.getHeap().insert(task);
		}
		Thread t = new Thread(timer);
		t.start();
		Thread.sleep(10000);
	}
}
