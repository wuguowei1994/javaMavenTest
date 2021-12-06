package com.wuguowei.test;

import java.util.PriorityQueue;

public class Main123 {
    PriorityQueue<Integer> l = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num) {
        int s1 = l.size();
        int s2 = r.size();

        // 如果两者相等, 优先放左边
        if (s1 == s2) {
            // 直接放左边, 无需从左边抽数据
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            }
            // 放右边, 不过要从右边抽一个放到左边
            else {
                // 先从右边抽一个, 放到左边
                l.add(r.poll());
                r.add(num);
            }
        }
        // 如果两者不相等, 左边一定大于右边, 优先考虑放右边
        else {
            // 直接放右边
            if (l.peek() <= num) {
                r.add(num);
            }
            // 从左边抽一个, 放右边
            else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }

    public double findMedian() {
        int s1 = l.size();
        int s2 = r.size();
        if (s1 == s2) {
            return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}
