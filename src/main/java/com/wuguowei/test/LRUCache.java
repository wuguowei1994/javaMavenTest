package com.wuguowei.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CAPACITY;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.MAX_CAPACITY = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CAPACITY;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(10);

        for (int i = 0; i < 11; i++) {
            cache.put(i, "Value" + i);
        }

        System.out.println("init");
        cache.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        cache.get(1);
        cache.get(2);
        cache.get(3);
        System.out.println("after get");
        cache.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        cache.put(5, "NewValue5");
        System.out.println("after put 5");
        cache.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        cache.put(11, "Value11");
        System.out.println("after put 11");
        cache.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
