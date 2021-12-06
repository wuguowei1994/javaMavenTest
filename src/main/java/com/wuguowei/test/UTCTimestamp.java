package com.wuguowei.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UTCTimestamp {
    public static void main(String[] args) throws ParseException {
        String inputDate = args[0];
        String year = inputDate.substring(0, 4);
        String month = inputDate.substring(4, 6);
        String day = inputDate.substring(6, 8);
        TimeZone.setDefault(TimeZone.getTimeZone("utc"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = format.parse(String.format("%s-%s-%s 00:00:00", year, month, day));
        System.out.println(parse.getTime());
        parse = format.parse(String.format("%s-%s-%s 23:59:59", year, month, day));
        System.out.println(parse.getTime());
    }
}
