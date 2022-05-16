package com.wuguowei.test;

import java.util.AbstractMap;
import java.util.Stack;

public class KuoHao {
    public static void main(String[] args) {}

    public static int longestLength(String s) {
        Stack<AbstractMap.SimpleEntry<Character, Integer>> stack = new Stack<>();
        int[] status = new int[s.length()];

        // 模拟有效括号匹配
        for (int i = 0; i < s.length(); i++) {

            AbstractMap.SimpleEntry<Character, Integer> entry =
                    new AbstractMap.SimpleEntry<>(s.charAt(i), i);

            if (stack.isEmpty() || s.charAt(i) == '(') {
                stack.push(entry);
            } else {
                AbstractMap.SimpleEntry<Character, Integer> peek = stack.peek();

                if (peek.getKey().equals('(')) {
                    status[peek.getValue()] = 1;
                    status[i] = 1;
                    stack.pop();
                } else {
                    stack.push(entry);
                }
            }
        }

        int maxLength = -1;
        int curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (status[i] != 1) {
                maxLength = Math.max(maxLength, curLength);
                curLength = 0;
            } else {
                curLength++;
            }
        }

        return Math.max(curLength, maxLength);
    }
}
