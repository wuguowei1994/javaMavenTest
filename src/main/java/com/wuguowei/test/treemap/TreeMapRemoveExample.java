package com.wuguowei.test.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapRemoveExample {

    public static void main(String[] args) {
        // 创建一个 TreeMap 并添加一些键值对
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Apple");
        treeMap.put(2, "Banana");
        treeMap.put(3, "Cherry");
        treeMap.put(4, "Date");
        treeMap.put(5, "Elderberry");
        treeMap.put(6, "Six");
        treeMap.put(9, "Nine");

        // 打印原始 TreeMap
        System.out.println("原始 TreeMap: " + treeMap);

        // 获取严格小于6的最大键值对
        Map.Entry<Integer, String> lowerEntry = treeMap.lowerEntry(6);
        System.out.println("lowerEntry(6): " + lowerEntry);

        // 获取严格大于6的最小键值对
        Map.Entry<Integer, String> higherEntry = treeMap.higherEntry(6);
        System.out.println("higherEntry(6): " + higherEntry);

        // 获取小于或等于6的最大键值对
        Map.Entry<Integer, String> floorEntry = treeMap.floorEntry(6);
        System.out.println("floorEntry(6): " + floorEntry);

        // 获取大于或等于6的最小键值对
        Map.Entry<Integer, String> ceilingEntry = treeMap.ceilingEntry(6);
        System.out.println("ceilingEntry(6): " + ceilingEntry);

        Map.Entry<Integer, String> firstEntry = treeMap.pollFirstEntry();
        System.out.println("移除的第一个条目: " + firstEntry);
        System.out.println("移除后的treeMap: " + treeMap);

        Map.Entry<Integer, String> lastEntry = treeMap.pollLastEntry();
        System.out.println("移除的最后一个条目: " + lastEntry);
        System.out.println("移除后的treeMap: " + treeMap);
    }
}
