/**
 * @(#)LastRemaining.java, 2018-01-02.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * LastRemaining
 * <p>
 * 圆圈中最后剩下的数
 *
 * @author lirongqian
 * @since 02/01/2018
 */
public class LastRemaining {

    public static void main(String[] args) {

    }

    /**
     * 约瑟夫环问题
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; ++i) {
            last = (last + m) % i;
        }
        // 因为实际编号为(1~n)
        return (last);
    }
}