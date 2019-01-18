package heaps.timer;

import heaps.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Timer implements Runnable {
	private List<Task> tasks = new ArrayList<>();
	private Heap<Task> heap = new Heap<>(10, new Comparator<Task>() {
		@Override
		public int compare(Task o1, Task o2) {
			return (int) (o2.getPeriod() - o1.getPeriod());
		}
	});

	public void run() {
		long preTime = 0;
		long curTime;
		System.out.println(heap.getCount());
		while (heap.getCount() > 0) {
			Task topTask = heap.deleteFirst();
			if (topTask != null) {
				curTime = topTask.getPeriod();
				try {
					Thread.sleep(curTime - preTime);
					preTime = curTime;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread t = new Thread(topTask);
				t.start();
			} else {
				break;
			}
		}
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public Heap<Task> getHeap() {
		return heap;
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int i = 1000; i < 10000; i += 1000) {
			Task task = new Task(i);
			timer.tasks.add(task);
			timer.heap.insert(task);
		}
		Thread t = new Thread(timer);
		t.start();
	}
}
