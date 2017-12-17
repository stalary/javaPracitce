/**
 * @(#)FindPivotIndex724.java, 2017-12-16.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * FindPivotIndex724
 *
 * 找出能分割数组的点的坐标，若不存在则返回-1
 * @author lirongqian
 * @since 2017/12/16
 */
public class FindPivotIndex724 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 7, 3, 6, 5, 6
        };
        FindPivotIndex724 f = new FindPivotIndex724();
        System.out.println(f.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int out : nums) {
            sum += out;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp == sum - temp + nums[i]) {
                return i;
            }
        }
        return -1;
    }
}