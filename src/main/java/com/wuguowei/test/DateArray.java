package com.wuguowei.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class DateArray {
    public static void main(String[] args) {
        String startDay = "20210101";
        String endDay = "20210103";
        ArrayList<String> strings = dateArray(startDay, endDay);
        System.out.println(strings);
        /*
        String start = "20210419";
        Integer delta = -3;
        ArrayList<String> strings = dateArray(start, delta);
        System.out.println(strings);
         */
    }

    // 生成startDay ~ endDay 的日期数组
    private static ArrayList<String> dateArray(String startDay, String endDay) {
        if (Integer.parseInt(startDay) > Integer.parseInt(endDay)) {
            return null;
        } else {
            ArrayList<String> res = new ArrayList<>();
            Calendar c1 = Calendar.getInstance();
            int year = Integer.parseInt(startDay.substring(0, 4));
            int month = Integer.parseInt(startDay.substring(4, 6)) - 1;
            int day = Integer.parseInt(startDay.substring(6, 8));
            c1.set(year, month, day);
            res.add(startDay);

            while (!startDay.equals(endDay)) {
                c1.add(Calendar.DATE, 1);
                startDay = new SimpleDateFormat("YYYYMMdd").format(c1.getTime());
                res.add(startDay);
            }
            return res;
        }
    }

    /*
    功能说明: 1. 若delta > 0, 生成 startDay ~ startDay + delta 的日期数组
             2. 若delta < 0, 生成 startDay - delta ~ startDay 的日期数组
    参数说明: 无
    完成时间: 2021/6/9
    函数作者: wuguowei
    */
    private static ArrayList<String> dateArray(String startDay, Integer delta) {
        ArrayList<String> res = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        int year = Integer.parseInt(startDay.substring(0, 4));
        int month = Integer.parseInt(startDay.substring(4, 6)) - 1;
        int day = Integer.parseInt(startDay.substring(6, 8));
        c1.set(year, month, day);
        res.add(startDay);
        for (int i = 0; i < Math.abs(delta); i++) {
            if (delta > 0) {
                c1.add(Calendar.DATE, 1);
            } else {
                c1.add(Calendar.DATE, -1);
            }
            startDay = new SimpleDateFormat("YYYYMMdd").format(c1.getTime());
            res.add(startDay);
        }
        if (delta < 0) {
            Collections.reverse(res);
        }
        return res;
    }
}
