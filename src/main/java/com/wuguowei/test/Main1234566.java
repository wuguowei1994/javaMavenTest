package com.wuguowei.test;

public class Main1234566 {
    private static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] a = {8, 6, 6, 2, 5, 4, 8, 10, 7};
        System.out.println(max(a, 0, a.length - 1));
    }

    public static int max(int[] a, int left, int right) {
        while (left < right) {
            int length = right - left;
            int hight = Math.min(a[left], a[right]);
            int value = length * hight;
            if (value > maxVal) {
                maxVal = value;
            }
            // 找下一个
            if (left + 1 < a.length && left + 1 < right && a[left + 1] > a[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return maxVal;
    }
}
