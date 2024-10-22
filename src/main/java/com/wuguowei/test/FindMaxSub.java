package com.wuguowei.test;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSub {

    public static void main(String[] args) {
        String a1 = "bbbaaadd";
        int k = 3;
        System.out.println(findMaxSub(a1, k));
    }

    public static int findMaxSub(String s, int k) {
        // 记录最长的子串长度
        int maxSubLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // 保存每个字符出现的次数
            HashMap<Character, Integer> charCount = new HashMap<>();
            charCount.put(s.charAt(i), 1);

            // 兼容只有1个字符的情况
            if (isValid(charCount, k) && maxSubLength < 1) {
                maxSubLength = 1;
            }

            for (int j = i + 1; j < s.length(); j++) {
                char current = s.charAt(j);
                int currentLength = j - i + 1;
                // 已经存在了，加1
                if (charCount.containsKey(current)) {
                    charCount.put(current, charCount.get(current) + 1);
                }
                // 不存在，存进去
                else {
                    charCount.put(current, 1);
                }

                // 判断是否满足条件
                if (isValid(charCount, k) && (currentLength > maxSubLength)) {
                    maxSubLength = currentLength;
                }
            }
        }

        return maxSubLength;
    }

    // 判断当前hashMap是否满足条件: 每个字符出现次数不小于k
    public static boolean isValid(HashMap<Character, Integer> charCount, int k) {
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            // 不满足条件
            if (entry.getValue() < k) {
                return false;
            }
        }

        // 满足条件
        return true;
    }
}
