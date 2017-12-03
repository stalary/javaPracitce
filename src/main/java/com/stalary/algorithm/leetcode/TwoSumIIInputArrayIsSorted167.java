/**
 * @(#)TwoSumIIInputArrayIsSorted.java, 2017-12-03.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * TwoSumIIInputArrayIsSorted
 *
 * 给一个有序的数组，输入一个目标数字，输出数组中能求和为这个目标数字的两个元素的下标，下标是从1开始的
 * @author lirongqian
 * @since 2017/12/3
 */
public class TwoSumIIInputArrayIsSorted167 {

    public static void main(String[] args) {
        int[] numbers = new int[] {
                2, 7, 11, 15
        };
        int[] arr = twoSum(numbers, 9);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] out = new int[2];
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int avg = numbers[i] + numbers[len - 1];
            if (target < avg) {
                i--;
                len--;
            } else if (target > avg) {
            } else {
                out[0] = i + 1;
                out[1] = len;
                return out;
            }
        }
        return out;
    }
}