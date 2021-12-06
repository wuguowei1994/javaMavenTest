package com.wuguowei.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        String s = "aaa";
        LOGGER.error("{}", s);
        try {

        } catch (Exception e){
            LOGGER.error("", e);
        }
    }
}
