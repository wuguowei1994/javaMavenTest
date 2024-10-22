package com.wuguowei.test;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int current_sum = 0;
        int min_length = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            current_sum += nums[right];

            // 不断尝试缩小窗口直到不满足条件
            while (current_sum >= target) {
                min_length = Math.min(min_length, right - left + 1);
                current_sum -= nums[left];
                left++;
            }
        }

        // 如果 min_length 没有被更新过，返回 0
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{1, 3, 2, 1, 6};
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}
