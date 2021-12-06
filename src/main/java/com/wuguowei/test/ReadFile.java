package com.wuguowei.test;

import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        InputStream inputStream = ReadFile.class.getResourceAsStream("/perfcounter_default.conf");
        if (inputStream == null) {
            System.out.println("file not exists!");
        } else {
            System.out.println("file exists!");
        }
    }
}
