package com.xwd.heaps.timer;

public class Task implements Runnable {
    private long period;

    public void run() {
        System.out.println("执行周期：" + period / 1000);
    }

    public long getPeriod() {
        return period;
    }

    public Task(long period) {
        this.period = period;
    }
}
