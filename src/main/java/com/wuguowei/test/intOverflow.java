package com.wuguowei.test;

public class intOverflow {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        Long aaaa = new Long(3019781766L);
        System.out.println(aaaa.intValue());
    }
}
