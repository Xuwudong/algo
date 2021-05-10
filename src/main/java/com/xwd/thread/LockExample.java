package com.xwd.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LXT
 * @create 2021/5/9 18:33
 */
public class LockExample {

    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                while(true) {
                    System.out.println("111");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread b = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            try {
                while(true) {
                    System.out.println("111");
                }
            }finally {
                lock.unlock();
            }
        });
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(1);
        b.interrupt();
    }
}
