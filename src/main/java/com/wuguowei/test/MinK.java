package com.wuguowei.test;

import java.util.ArrayList;

public class MinK {

    public static void main(String[] args) {
        int[] c = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetSolution(c, 4));
    }

    public static ArrayList<Integer> GetSolution(int[] input, int k) {
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }

        // 弄一个最大堆, 大小为k
        int[] a = new int[k];
        System.arraycopy(input, 0, a, 0, k);

        // 从最后一个非叶子节点, 开始往前回溯
        for (int i = k / 2 - 1; i >= 0; i--) {
            rebalance(i, a, k);
        }

        // 遍历剩余的节点
        for (int i = k; i < input.length; i++) {
            if (input[i] < a[0]) {
                a[0] = input[i];
                rebalance(0, a, k);
            }
        }

        // 把大顶堆升序排列
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            rebalance(0, a, i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : a) {
            ans.add(x);
        }
        return ans;
    }

    /**
     * @param index 维护当前堆的下标
     * @param a 堆
     * @param length 堆的节点个数
     */
    private static void rebalance(int index, int[] a, int length) {
        // 保存当前值
        int temp = a[index];
        for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
            // 找出左右子节点的最大值
            if ((k + 1) < length && a[k + 1] > a[k]) {
                k = k + 1;
            }

            // 子节点比父节点大, 要替换
            if (a[k] > temp) {
                a[index] = a[k];
                // 更新index的值, 使之始终等于形参index最终要去的位置
                index = k;
            } else {
                break;
            }
        }
        a[index] = temp;
    }
}
