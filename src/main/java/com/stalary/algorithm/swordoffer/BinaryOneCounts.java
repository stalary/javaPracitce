/**
 * @(#)BinaryOneCounts.java, 2017-12-06.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * BinaryOneCounts
 *
 * 求一个数字转化为二进制后1的个数，注意负数的情况
 * @author lirongqian
 * @since 2017/12/6
 */
public class BinaryOneCounts {

    public static void main(String[] args) {
        int a = -7;
        System.out.println(calculate(a));
    }

    public static int calculate(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // 此处不能使用n = n >> 1，因为当为负数时会超时
            n = (n - 1) & n;
        }
        return count;
    }
}