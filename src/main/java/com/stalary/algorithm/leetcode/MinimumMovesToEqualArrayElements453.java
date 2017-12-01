/**
 * @(#)MinimumMovesToEqualArrayElements453.java, 2017-11-30.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MinimumMovesToEqualArrayElements453
 *
 * 输入一个数组，每次移动都可以对两个数字++，求最小移动次数使所有的值都相同
 * 因为我们小的加的和大的一样大，和大的减到和小的一样小是一样的，所以我们可以先求出最小值，然后再求出每个数字与最小值的差
 * @author lirongqian
 * @since 2017/11/30
 */
public class MinimumMovesToEqualArrayElements453 {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 2, 3
        };
        System.out.println(minMoves(nums));
    }

    public static int minMoves(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int sum = 0;
        for (int n : nums) {
            sum += n - min;
        }
        return sum;
    }
}