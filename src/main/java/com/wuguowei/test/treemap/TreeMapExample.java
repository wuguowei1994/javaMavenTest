package com.wuguowei.test.treemap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Apple");
        treeMap.put(2, "Banana");
        treeMap.put(3, "Cherry");
        treeMap.put(4, "Date");
        treeMap.put(5, "Elderberry");

        System.out.println("原始 TreeMap:" + treeMap);

        // 获取小于3的部分
        Map<Integer, String> headMap = treeMap.headMap(3);
        System.out.println("headMap(小于3）:" + headMap);

        // 获取大于等于3的部分
        Map<Integer, String> tailMap = treeMap.tailMap(3);
        System.out.println("tailMap(大于等于3):" + tailMap);

        // 获取 2(包含) 到 4(不包含) 的部分
        Map<Integer, String> subMap = treeMap.subMap(2, 4);
        System.out.println("subMap(2(包含)到4(不包含):" + subMap);

        treeMap.put(6, "Fig");
        System.out.println("添加新元素后的treeMap:" + treeMap);
        System.out.println("headMap(小于3）:" + headMap);
        System.out.println("tailMap(大于等于3):" + tailMap);
        System.out.println("subMap(2(包含)到4(不包含):" + subMap);
    }
}
