/**
 * @(#)Fibonacci.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * Fibonacci
 *
 * @author lirongqian
 * @since 2017/12/4
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciNoRecursion(2));
    }

    /**
     * 递归方法，不推荐使用
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 非递归方法
     */
    public static int fibonacciNoRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        return a[n];
    }
}