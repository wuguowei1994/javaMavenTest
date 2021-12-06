package com.wuguowei.test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class testStream {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        List<Integer> res = intStream.limit(100).boxed().collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}
