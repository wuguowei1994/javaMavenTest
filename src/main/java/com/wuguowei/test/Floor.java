package com.wuguowei.test;

public class Floor
{
  public static void main(String[] args)
  {
    // 楼层阶梯个数
    int n = 4;

    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2; // 先走一步，或者直接走两步
    dp[3] = 4; // 走三个一步 或 走一步、走两步 或 走两步、走一步 或直接走三步

    // 状态转移
    // dp[i] = dp[i-1] // 上一个台阶直接走一步
    // + dp[i-2] // 前两个台阶直接走上来
    // + dp[i-3] // 前三个台阶一步走上来
    for(int i = 4; i < n+1; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    System.out.println(dp[n]);

  }
}
