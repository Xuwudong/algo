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
            return (int) (o1.getPeriod() - o2.getPeriod());
        }
    });

    private long nextTime;

    public void run() {
        int n = 1;
        while (true) {

            Task topTask = heap.getArr()[n++ % heap.getCount()];
            if (topTask != null) {
                nextTime = topTask.getPeriod();
                try {
                    Thread.sleep(nextTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread t = new Thread(topTask);
                t.start();
            }

        }
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
