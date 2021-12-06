package com.wuguowei.test;

public class RunClass {
    public static final String JOB_NAME = "event-join";
    public static void main(String[] args) {

        TestString testString = new TestString(JOB_NAME);
        testString.updateCnt();
    }
}
