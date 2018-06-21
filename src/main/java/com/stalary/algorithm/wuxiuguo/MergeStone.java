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
        int[] num = new int[]{13, 7, 8, 16, 21, 4, 18};
        System.out.println(mergeStone(num));
    }

    public static int getSum(int[] num, int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += num[i];
        }
        return sum;
    }

    public static int mergeStone(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int[][] dp = new int[A.length][A.length];
        // 合并石子堆数
        for (int len = 1; len < A.length; len++) {
            for (int i = 0; i < A.length - len; i++) {
                int j = i + len;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + getSum(A, i, j));
                }
                dp[i][j] = min;
            }
        }
        return dp[0][A.length - 1];
    }
}