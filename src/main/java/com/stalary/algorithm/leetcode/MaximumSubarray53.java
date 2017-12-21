/**
 * @(#)MaximumSubarray53.java, 2017-12-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MaximumSubarray53
 * <p>
 * 求出最大子数组的和
 *
 * @author lirongqian
 * @since 21/12/2017
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        System.out.println(new MaximumSubarray53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
}