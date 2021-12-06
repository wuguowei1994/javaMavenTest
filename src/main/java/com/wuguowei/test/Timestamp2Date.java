package com.wuguowei.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp2Date {
    public static void main(String[] args) {
        String hour = new SimpleDateFormat("yyyyMMddHH").format(new Date(0L)).substring(8, 10);
        System.out.println(hour);
    }
}
