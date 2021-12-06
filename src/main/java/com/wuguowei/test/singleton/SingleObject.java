package com.wuguowei.test.singleton;

public class SingleObject {
    private static SingleObject instance;

    private SingleObject(String event) {
        System.out.println("get into construct function, event is " + event);
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World");
    }
}
