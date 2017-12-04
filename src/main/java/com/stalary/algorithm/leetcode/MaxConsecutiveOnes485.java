/**
 * @(#)MaxConsecutiveOnes485.java, 2017-11-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MaxConsecutiveOnes485
 *
 * @author lirongqian
 * @since 2017/11/22
 */
public class MaxConsecutiveOnes485 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 0
        };
        System.out.println(findMaxConsecutiveOnes2(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 0) {
                // 重置
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        for (int i = 0, cnt = 0; i < nums.length; i++) {
            max = (cnt = nums[i] == 1 ? cnt + 1 : 0) > max ? cnt : max;
        }
        return max;
    }

    /**
     * 超时！
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes2(int[] nums) {

        String str = "";
        for (int n : nums) {
            str += n;
        }
        if (str.matches("^0*$")) {
            return 0;
        }
        String[] out = str.split("0");
        int max = out[0].length();
        for (int i = 0; i < out.length; i++) {
            max = max > out[i].length() ? max : out[i].length();
        }
        return max;
    }
}