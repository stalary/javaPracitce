/**
 * @(#)CountingBits338.java, 2018-01-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * CountingBits338
 *
 * 给定一个数字n，求出n范围内每个数字的二进制中1的个数
 * @author lirongqian
 * @since 2018/01/06
 */
public class CountingBits338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits338().countBits(0)));
    }

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i / 2] + i % 2;
        }
        return arr;
    }
}