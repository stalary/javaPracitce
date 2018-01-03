/**
 * @(#)Sum.java, 2018-01-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * Sum
 *
 * 不使用运算符以及循环语句等进行求和
 * @author lirongqian
 * @since 03/01/2018
 */
public class Sum {

    public static void main(String[] args) {
        System.out.println(new Sum().Sum_Solution(4));
    }

    public int Sum_Solution(int n) {
        int sum = n;
        // 当n = 0时则不再进行递归
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}