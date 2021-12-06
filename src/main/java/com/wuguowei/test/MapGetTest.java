package com.wuguowei.test;

import java.util.HashMap;
import java.util.Map;

public class MapGetTest {
    private static final Map<String, String> tagIdHourTTLMap = new HashMap<>();

    public static void main(String[] args) {
        tagIdHourTTLMap.put("abc", "wuguowei");

        tagIdHourTTLMap.getOrDefault("abc", hello());
        tagIdHourTTLMap.computeIfAbsent("abc", a -> hello());
    }

    private static String hello() {
        System.out.println("get into hello");
        return "hello";
    }
}
