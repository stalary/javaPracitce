/**
 * @(#)DistributeCandies575.java, 2017-11-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * DistributeCandies575
 *
 * 将数组分为两块，求出最大的不重复部分是多少
 * 注意hash数组大小的申请，避免越界，boolean[][2]，0代表负数，1代表正数
 *
 * @author lirongqian
 * @since 2017/11/20
 */
public class DistributeCandies575 {

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 11
        };
        Arrays.sort(a);
        boolean[][] b = new boolean[Math.max(Math.abs(a[0]), a[a.length - 1]) + 1][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                b[a[i]][1] = true;
            } else {
                b[Math.abs(a[i])][0] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i][1]) {
                count++;
            }
            if (b[i][0]) {
                count++;
            }
        }
        int finalOut = count < a.length / 2 ? count : a.length / 2;
        System.out.println(finalOut);
    }
}