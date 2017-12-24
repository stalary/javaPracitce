/**
 * @(#)PlusOne66.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * PlusOne66
 *
 * 把一个数字的每一位存到一个数组中，对这个数字加1返回
 * @author lirongqian
 * @since 24/12/2017
 */
public class PlusOne66 {

    public static void main(String[] args) {

    }

    /**
     * 如果加1未产生进位则直接加1返回，否则向上进位，如果首位超过9，则需要扩大一个元素的数组，加1
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}