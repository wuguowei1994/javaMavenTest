package com.wuguowei.test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSolution {

    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void method1() {
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 获得锁1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁2");
            } finally {
                lock2.unlock();
            }

        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        lock2.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 获得锁2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁1");
            } finally {
                lock1.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockSolution example = new ReentrantLockSolution();

        Thread t1 = new Thread(() -> {
            example.method1();
        }, "线程1");

        Thread t2 = new Thread(() -> {
            example.method2();
        }, "线程2");

        t1.start();
        t2.start();
    }
}
