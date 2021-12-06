package com.wuguowei.test;

import java.util.HashSet;
import java.util.Set;

public class testContains {
    private static final Set<String> highUnjoinedRate = new HashSet<String>() {{
        add("1.315.4.34");
        add("1.315.4.30");
        add("1.315.4.35");
        add("1.315.4.13");
        add("1.315.4.33");
        add("1.315.4.39");
        add("1.315.4.25");
        add("1.315.4.40");
        add("1.315.4.32");
        add("1.316.6.1");
        add("1.315.4.26");
        add("1.315.4.38");
        add("1.315.4.18");
        add("1.338.4.3");
        add("1.38.1.1");
        add("1.338.4.5");
        add("1.315.4.41");
        add("1.38.3.1");
        add("1.24.4.1");
        add("1.38.5.4");
        add("1.308.1.700");
        add("1.308.1.1600");
    }};

    public static void main(String[] args) {
        String s = new String("123");
        s = "1.315.4.34";
        System.out.println(highUnjoinedRate.contains(s));

    }
}
