/**
 * @(#)NumberOf1Bits191.java, 2017-12-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * NumberOf1Bits191
 *
 * @author lirongqian
 * @since 20/12/2017
 */
public class NumberOf1Bits191 {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits191().hammingWeight(11));
    }

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i & 1) == 1 ? 1 : 0;
        }
        return count;
    }
}