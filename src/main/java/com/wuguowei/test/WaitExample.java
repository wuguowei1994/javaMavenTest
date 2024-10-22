package com.wuguowei.test;

public class WaitExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread A: Waiting for lock...");
                try {
                    lock.wait();  // 释放锁并等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread A: Resumed after waiting!");
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread B: Holding lock and will notify...");
                lock.notify();  // 唤醒等待的线程
                System.out.println("Thread B: Notified Thread A, doing more work...");
                try {
                    Thread.sleep(1000);  // 模拟线程 B 继续占用锁一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread B: Finished work, releasing lock...");
            }
        });

        threadA.start();
        threadB.start();
    }
}
