/**
 * @(#)MoveZeroes238.java, 2017-11-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MoveZeroes238
 *
 * @author lirongqian
 * @since 2017/11/25
 */
public class MoveZeroes283 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 1, 0, 3, 12
        };
        moveZeroes(nums);
        for (int out : nums) {
            System.out.println(out + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}