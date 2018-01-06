/**
 * @(#)ArithmeticSlices413.java, 2018-01-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ArithmeticSlices413
 *
 * 判断数组中差值全为一样的子数组，数组的最小长度为3
 * @author lirongqian
 * @since 2018/01/06
 */
public class ArithmeticSlices413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int temp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                temp++;
                sum += temp;
            } else {
                temp = 0;
            }
        }
        return sum;
    }
}