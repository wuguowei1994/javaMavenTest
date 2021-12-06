package com.wuguowei.test;

import java.util.PriorityQueue;

public class MedianFinder {
    // 大顶堆
    private final PriorityQueue<Integer> l = new PriorityQueue<>((a, b) -> b - a);

    // 小顶堆
    private final PriorityQueue<Integer> r = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num) {
        int s1 = l.size();
        int s2 = r.size();

        if (s1 == s2) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        }
        // 两者不相等, 一定是左边的多
        else {
            if (l.peek() <= num) {
                r.add(num);
            } else {
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
