/**
 * @(#)ArrayPartitionI561.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * ArrayPartitionI561
 *
 * 求两个数之间较小数的所有数字和
 * @author lirongqian
 * @since 2017/11/15
 */
public class ArrayPartitionI561 {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,4,3,2
        };
        System.out.println(arrayPairSum(nums));
    }

    /**
     * 1，4，3，2-》min(1，2) + min(3，4) = 4
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}