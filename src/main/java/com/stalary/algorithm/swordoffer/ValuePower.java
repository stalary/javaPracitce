/**
 * @(#)ValuePower.java, 2017-12-06.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * ValuePower
 *
 * 求一个小数的整数次方，注意负数的情况，可以利用递归或者基本的累乘法。
 * @author lirongqian
 * @since 2017/12/6
 */
public class ValuePower {

    public static void main(String[] args) {
        System.out.println(power(2, -3));
    }

    public static double power(double base, int exponent) {
        int n = exponent > 0 ? exponent : -exponent;
        double result = 0.0;
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return base;
        }
        result = power(base, n >> 1);
        result *= result;
        // 奇数时，需要再乘一次底数
        if ((n & 1) == 1) {
           result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    public static double power1(double base, int exponent) {
        double result = 1.0;
        int n = exponent > 0 ? exponent : -exponent;
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        if (exponent >= 0) {
            return result;
        } else {
            return 1 / result;
        }
    }
}