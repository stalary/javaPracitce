/**
 * @(#)MinCostClimbingStairs746.java, 2017-12-19.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MinCostClimbingStairs746
 * <p>
 * 给定一个数组，代表每一步的花费，每次可以移动一步或者两步，求最少花费多少到达顶部
 *
 * @author lirongqian
 * @since 19/12/2017
 */
public class MinCostClimbingStairs746 {

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(new int[]{
                10, 15, 20
        }));
    }

    /**
     * 使用动态规划，重点是找到状态转移方程，可以看出每次的最后的花费是每次的花费加上上次最小的花费，若本次花费大于下次花费，可以跳过
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;
        int f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            // 跳过的步数
            f2 = f1;
            // 走的步数
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}