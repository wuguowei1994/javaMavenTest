package com.wuguowei.test;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[][] a = new int[2][3];
        a[0][0] = 1;
        a[0][1] = 5;
        a[0][2] = 7;
        System.out.println(Arrays.deepToString(a));

        int[][] b = {{12, 17, 20}, {80, 89, 90}};
        System.out.println(Arrays.deepToString(b));
    }
}
