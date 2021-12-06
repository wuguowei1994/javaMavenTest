package com.wuguowei.test;


import lombok.SneakyThrows;

public class RunnableTest {

    public static class testaaa implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(10000);
        }
    }

    public static void main(String[] args) {
        //new testaaa().run();
        new Thread(new testaaa()).start();
        System.out.println("aaaa");
    }
}
