package com.wuguowei.test.threadpool;

public class ThreadBlockQ {
    public static void main(String[] args) throws InterruptedException {
        ThreadExcutor executor = new ThreadExcutor(3);
        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            executor.exec(
                    () -> {
                        System.out.println(
                                "thread "
                                        + Thread.currentThread().getName()
                                        + "start doing task "
                                        + taskNum);

                    });
        }
        executor.shutdown();
    }
}
