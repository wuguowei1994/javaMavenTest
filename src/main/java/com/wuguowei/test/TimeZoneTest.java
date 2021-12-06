package com.wuguowei.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) throws ParseException {
        String timeStr = "20210901 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date d = sdf.parse(timeStr);
        System.out.println(sdf.format(d) + " , " + d.getTime());
    }
}
