package com.xwd.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author LXT
 * @create 2021/4/30 21:29
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(() -> {
            while(true) {
                System.out.println("111");
//                System.out.println(Thread.interrupted());
                Thread.currentThread().interrupt();
                LockSupport.park(new InterruptTest());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        t.start();
        Thread.sleep(2000);
//        t.interrupt();
    }
}
