/**
 * @(#)NumberOf1Between1AndN.java, 2017-12-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * NumberOf1Between1AndN
 *
 * 从1-n的数组中求出1的个数
 * @author lirongqian
 * @since 21/12/2017
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(13));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += countOne(i);
        }
        return sum;
    }

    public int countOne(int n) {
        int count = 0;
        int temp;
        while (n >= 10) {
            temp = n % 10;
            if (temp == 1) {
                count++;
            }
            n = n / 10;
        }
        if (n == 1) {
            count++;
        }
        return count;
    }
}