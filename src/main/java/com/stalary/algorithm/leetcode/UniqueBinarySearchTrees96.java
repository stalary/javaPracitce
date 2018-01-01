/**
 * @(#)UniqueBinarySearchTrees96.java, 2018-01-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * UniqueBinarySearchTrees96
 *
 * 给定一个数字n，求1-n的数字能够组成多少种二叉搜索树
 * @author lirongqian
 * @since 01/01/2018
 */
public class UniqueBinarySearchTrees96 {

    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 第一层循环是根的数量
        for (int level = 2; level <= n; level++) {
            // 第二层循环是
            for (int root = 1; root <= level; root++) {
                dp[level] += dp[level - root] * dp[root - 1];
            }
        }
        return dp[n];
    }
}