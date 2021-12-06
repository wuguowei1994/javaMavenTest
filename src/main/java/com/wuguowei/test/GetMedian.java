package com.wuguowei.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetMedian {
    private static final ArrayList<Integer> arr = new ArrayList<>();
    private static int inputSize = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int input = sc.nextInt();
            inputSize++;

            appendNumber(input);
            System.out.println(getMedian());
        }
    }

    // 获取中位数
    public static double getMedian() {
        if (inputSize == 0) {
            return 0;
        }
        // 偶数
        if (inputSize % 2 == 0) {
            int left = arr.get(inputSize / 2 - 1);
            int right = arr.get(inputSize / 2);
            return (left + right) * 1.0 / 2;
        }
        // 奇数
        else {
            return arr.get(inputSize / 2);
        }
    }

    // 先把新元素添加到arrayList, 再按从小到大排序
    public static void appendNumber(int a) {
        arr.add(a);

        // arrayList 转 int[]
        int[] tmp = new int[inputSize];
        int index = 0;
        for (int tmpArr : arr) {
            tmp[index] = tmpArr;
            index++;
        }

        // 排序
        Arrays.sort(tmp);

        // int[]转arrayList
        arr.clear();
        for (int i = 0; i <= index - 1; i++) {
            arr.add(tmp[i]);
        }
    }
}
