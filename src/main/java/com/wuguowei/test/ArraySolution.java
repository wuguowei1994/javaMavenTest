package com.wuguowei.test;

public class ArraySolution
{
  // 数列0，1，1，2，4，7，13，24，44... 查看数列规律，使用非递归计算数列第n个位置的值。
  public static void main(String[] args)
  {
    int n = 6;

    System.out.println("第 " + n + "个位置的值是:" + findSolution(n));
  }

  // 返回第n个位置的值
  public static int findSolution(int n)
  {
    // 处理边界条件
    if (n < 0) {
      return 0;
    }

    // 如果 n 比较小，直接返回前面那些
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 1;
    }
    // 当 n 大于 3, 才使用计算
    // 用三个变量保存当前用到的值
    int left = 0;
    int middle = 1;
    int right = 1;
    // 直接用一个变量保存结果
    int result = 0;
    for (int i = 3; i < n + 1; i++) {
      result = left + middle + right;
      // 计算完成后, 变量统一向右移动
      //// 数列0，1，1，2，4，7，13，24，44...
      int tmp = middle;
      middle = right;
      right = result;
      left = tmp;
    }
    return result;
  }
}
