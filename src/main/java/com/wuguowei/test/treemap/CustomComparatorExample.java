package com.wuguowei.test.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomComparatorExample {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String str1, String str2) {
                // 先按字符串长度排序
                int lenComparison = Integer.compare(str1.length(), str2.length());

                // 如果长度相同, 按字母顺序排序
                if (lenComparison == 0) {
                    return str1.compareTo(str2);
                }

                return lenComparison;
            }
        });

        treeMap.put("apple", 1);
        treeMap.put("banana", 2);
        treeMap.put("pear", 3);
        treeMap.put("kiwi", 4);
        treeMap.put("cherry", 5);

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
