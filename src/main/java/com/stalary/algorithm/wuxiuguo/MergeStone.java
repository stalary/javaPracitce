/**
 * @(#)MergeStone.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * MergeStone
 * 合并石子
 * @author lirongqian
 * @since 2018/06/20
 */
public class MergeStone {

    public static void main(String[] args) {
        int[] num = new int[]{13, 8, 5};
        System.out.println(mergeStone(num));
    }

    public static int getSum(int[] num, int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += num[i];
        }
        return sum;
    }

    public static int mergeStone(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        // 合并石子堆数
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                int min = Integer.MAX_VALUE;
                // 传入的a下标从0开始，所以需要减1
                int sum = getSum(a, i - 1, j - 1);
                for (int k = i; k < j; k++) {
                    // 动态规划方程，找到最小值
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + sum);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}