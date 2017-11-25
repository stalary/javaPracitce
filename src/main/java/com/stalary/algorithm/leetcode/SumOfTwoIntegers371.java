/**
 * @(#)SumOfTwoIntegers371.java, 2017-11-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SumOfTwoIntegers371
 *
 * 使用移位操作完成a + b
 * @author lirongqian
 * @since 2017/11/25
 */
public class SumOfTwoIntegers371 {

    public static void main(String[] args) {
        System.out.println(getSum(1,2));
    }

    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            // 获取进位
            int temp = a & b;
            // 获取不同的位
            a = a ^ b;
            // 进位移动一位
            b = temp << 1;
        }
        return a;
    }
}