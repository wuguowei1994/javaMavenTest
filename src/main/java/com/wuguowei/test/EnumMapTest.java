package com.wuguowei.test;

import java.time.DayOfWeek;
import java.util.*;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        /*
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
         */
        if(map == null) {
            System.out.println("is null");
        } else {
            System.out.println("is not null");
        }

        HashMap<String, String> aaaa = new HashMap<>();
        if(aaaa == null){
            System.out.println("is null");
        } else {

        }
    }
}
