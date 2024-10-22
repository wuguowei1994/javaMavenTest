package com.wuguowei.test;

public class SleepExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread A: Holding lock and will sleep...");
                try {
                    Thread.sleep(3000);  // 睡眠3秒，期间不释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread A: Woke up and releasing lock...");
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread B: Acquired lock, doing work...");
            }
        });

        threadA.start();
        try {
            // 等待 threadA 获得锁
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
