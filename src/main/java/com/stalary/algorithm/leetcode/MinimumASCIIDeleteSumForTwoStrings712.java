/**
 * @(#)MinimumASCIIDeleteSumForTwoStrings712.java, 2018-01-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * MinimumASCIIDeleteSumForTwoStrings712
 * <p>
 * 给定两个字符串，求删掉两个字符串中最小的元素
 *
 * @author lirongqian
 * @since 2018/01/06
 */
public class MinimumASCIIDeleteSumForTwoStrings712 {

    public static void main(String[] args) {
        System.out.println(new MinimumASCIIDeleteSumForTwoStrings712().minimumDeleteSum("sea", "eat"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length(), min = Integer.MAX_VALUE;
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m || j < n) {
                    dp[i][j] = i < m && j < n && a[i] == b[j] ?
                            dp[i + 1][j + 1] : Math.min((i < m ? a[i] + dp[i + 1][j] : min), (j < n ? b[j] + dp[i][j + 1] : min));
                }
            }
        }
        return dp[0][0];
    }
}