package com.wuguowei.test.treemap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTraversal {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        map.put("Date", 4);
        map.put("Elderberry", 5);

        for (int i = 0; i < 4; i++) {
            System.out.println("遍历第" + i + "次");
            // 遍历HashMap键值对

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

            System.out.println();
        }
    }
}
