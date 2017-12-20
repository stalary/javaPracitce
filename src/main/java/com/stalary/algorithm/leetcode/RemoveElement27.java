/**
 * @(#)RemoveElement27.java, 2017-12-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * RemoveElement27
 *
 * 输入一个数组，一个值，删除数组中的目标值，返回数组剩余的长度
 * @author lirongqian
 * @since 20/12/2017
 */
public class RemoveElement27 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 2, 2, 3
        };

        System.out.println(new RemoveElement27().removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }
        return begin;
    }
}