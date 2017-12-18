/**
 * @(#)PowerOfThree326.java, 2017-12-18.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * PowerOfThree326
 * <p>
 * 输入一个数字，判断是否是3的幂次方
 *
 * @author lirongqian
 * @since 2017/12/18
 */
public class PowerOfThree326 {

    public static void main(String[] args) {
        System.out.println(new PowerOfThree326().isPowerOfThree(1));
    }

    public boolean isPowerOfThree(int n) {
        // 1162261467是3^19，20时越界
        return (n > 0 && 1162261467 % n == 0);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}