package com.wuguowei.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2Long {
    public static void main(String[] args) {
        String now = "20210412";
        String format = new SimpleDateFormat("YYYYMMdd").format(new Date());
        System.out.println("format: " + format);
        if (now.equals(format)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
