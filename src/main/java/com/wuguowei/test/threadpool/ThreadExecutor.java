package com.wuguowei.test.threadpool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadExcutor {
    private volatile boolean RUNNING = true;

    private static BlockingQueue<Runnable> taskQueue = null;

    private final HashSet<Worker> workers = new HashSet<>();

    private final List<Thread> threadList = new ArrayList<>();

    private final int poolSize;
    private volatile int workerSize = 0;

    private volatile boolean shutdown = false;

    public ThreadExcutor(int poolSize) {
        this.poolSize = poolSize;
        taskQueue = new LinkedBlockingQueue<>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null) throw new NullPointerException();
        if (workerSize < poolSize) {
            addThread(runnable);
        } else {
            try {
                taskQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Runnable runnable) {
        workerSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        RUNNING = false;
        if (!workers.isEmpty()) {
            for (Worker worker : workers) {
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            taskQueue.offer(runnable);
        }

        @Override
        public void run() {
            while (RUNNING) {
                if (shutdown) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return taskQueue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread : threadList) {
                System.out.println("start interrupt thread " + thread.getName());
                thread.interrupt();
            }
        }
    }
}
