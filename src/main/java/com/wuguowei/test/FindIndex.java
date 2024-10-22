package com.wuguowei.test;

public class FindIndex {

    public static void main(String[] args) {
        int[] input1 = new int[]{11,24,71,1,2,4,8};
        System.out.println(findIndex(input1));

        int[] input2 = new int[]{9,10,2,3,4};
        System.out.println(findIndex(input2));

        int[] input3 = new int[]{9,10,2,3,4,5};
        System.out.println(findIndex(input3));
    }

    // 寻找旋转点, 输出原数组旋转点的index
    // 例如 [11,24,71,1,2,4,8], 则返回 index = 3
    public static int findIndex(int[] arr) {
        int res = 0;
        // 用二分查找法
        int start = 0;
        int end = arr.length - 1;
        int index = (start + end + 1) / 2; // 7 / 2 = 3

        while(start <= end) {
            // 证明旋转点位于 (index+1, end) 之间
            if(arr[index] >= arr[start]) {
                // 如果arr[index+1]刚好小于arr[index], 那么就是这个节点
                if(arr[index + 1] < arr[index]) {
                    res = index + 1;
                    break;
                }
                start = index + 1;
                index = (start + end) / 2;
            }
            // 证明旋转点位于 (start, index-1)之间
            else if(arr[index] < arr[start]){
                // 如果arr[index-1]刚好大于arr[index], 那么就是这个节点
                if(arr[index-1] > arr[index]) {
                    res = index;
                }
                end = index - 1;
                index = (start + end) / 2;
            }
        }
        return  res;
    }
}
