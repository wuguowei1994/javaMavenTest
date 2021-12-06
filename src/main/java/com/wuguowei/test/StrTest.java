package com.wuguowei.test;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class StrTest {
    @Data
    public static class test {
        public int Yaya;

        public test(int in) {
            Yaya = in;
        }
    }

    public static void main(String[] args) {
        /*
        String aaa = "aaa";
        aaa = aaa.toUpperCase();
        System.out.println(aaa);
         */
        /*
        String aaa = "VIEW-1.2.3.4";
        String[] split = aaa.split("-");
        System.out.println(split.length);
        System.out.println(split[0]);
        System.out.println(split[1]);
         */
        Map<String, test> aaa = new HashMap<>();
        aaa.put("1", new test(456));
        System.out.println(aaa.get("1"));
        update(aaa.get("1"));
        System.out.println(aaa.get("1"));
    }

    public static void update(test aaa) {
        aaa.Yaya = 0;
    }
}
