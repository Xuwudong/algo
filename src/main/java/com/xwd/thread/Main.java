package com.xwd.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LXT
 * @create 2021/5/6 21:51
 */
public class Main {
    static class A {

    }

    private static volatile boolean flag = false;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            int i = 1;
            while (i <= 5) {
                lock.lock();
                try {
                    if(flag) {
                        System.out.print(i++);
                         flag = false;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread b = new Thread(() -> {
            int i = 1;
            while (i <= 5) {
                lock.lock();
                try {
                    if (!flag) {
                        System.out.print(i++);
                        flag = true;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
//        Thread a = new Thread( () -> {
//            int i = 1;
//            while(i <= 5) {
//                synchronized (lock) {
//                    if (flag) {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        System.out.print(i++);
//                        flag = true;
//                        lock.notify();
//                    }
//                }
//            }
//        });
//        Thread b = new Thread(() -> {
//            int i = 1;
//            while(i <= 5) {
//                synchronized (lock){
//                    if(!flag) {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        System.out.print(i++);
//                        flag = false;
//                        lock.notify();
//                    }
//
//                }
//            }
//        });
        a.start();
        b.start();
    }
}
