package com.wuguowei.test;

public class FindMaxProfile {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(findMaxVal(prices));
    }

    public static int findMaxVal(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 最高的收益
        int maxProfile = 0;

        // 先计算一次买卖的情况
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 可以卖出
                if (prices[j] > prices[i]) {
                    int profile = prices[j] - prices[i];
                    // 更新最大收益
                    if (profile > maxProfile) {
                        maxProfile = profile;
                    }
                }
            }
        }

        // 计算两次买卖的情况
        // 两次买卖，至少留两个元素
        for (int i = 0; i < prices.length - 3; i++) {
            for (int j = i + 1; j < prices.length - 2; j++) {
                // 尝试第一次卖出
                if (prices[j] > prices[i]) {
                    // 第一次卖出的收益
                    int profile1 = prices[j] - prices[i];

                    // 对剩下的元素, 尝试做第二次卖出
                    for (int k = j + 1; k < prices.length - 1; k++) {
                        for (int l = k + 1; l < prices.length; l++) {
                            if (prices[l] > prices[k]) {
                                int profile2 = prices[l] - prices[k];

                                // 计算两次卖出的总收益
                                int profile = profile1 + profile2;
                                if (profile > maxProfile) {
                                    maxProfile = profile;
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxProfile;
    }
}
