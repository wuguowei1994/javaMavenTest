package com.wuguowei.test.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
        SingleObject object2 = SingleObject.getInstance();
        object2.showMessage();
    }
}
