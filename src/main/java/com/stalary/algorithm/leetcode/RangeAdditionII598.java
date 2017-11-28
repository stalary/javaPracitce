/**
 * @(#)RangeAdditionII598.java, 2017-11-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * RangeAdditionII598
 *
 * @author lirongqian
 * @since 2017/11/28
 */
public class RangeAdditionII598 {

    public static void main(String[] args) {
        int[][] ops = new int[][]{
                {2, 2}, {3, 3}
        };
        System.out.println(maxCount(3, 3, ops));
    }

    public static int maxCount(int m, int n, int[][] ops) {
        for (int i = 0; i < ops.length; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }
        return m * n;
    }
}