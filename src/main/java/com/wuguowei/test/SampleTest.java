package com.wuguowei.test;

import java.util.Random;

public class SampleTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextDouble() < 0.9);
        }
    }
}
