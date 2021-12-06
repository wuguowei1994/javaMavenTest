package com.wuguowei.test;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.forEach(event -> {
            if (event == 2) {
                return;
            }
            System.out.println("event : " + event);
        });
    }
}
