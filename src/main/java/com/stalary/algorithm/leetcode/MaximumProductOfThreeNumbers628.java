/**
 * @(#)MaximumProductOfThreeNumbers628.java, 2017-12-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * MaximumProductOfThreeNumbers628
 *
 * @author lirongqian
 * @since 2017/12/9
 */
public class MaximumProductOfThreeNumbers628 {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 2, 3, 4
        };
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[len - 1] * nums[0] * nums[1]);
    }
}