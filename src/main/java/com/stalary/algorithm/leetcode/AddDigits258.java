/**
 * @(#)AddDigits258.java, 2017-11-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * AddDigits258
 *
 * @author lirongqian
 * @since 2017/11/25
 */
public class AddDigits258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        if (sum < 10) {
            return sum;
        } else if (sum == 10) {
            return 1;
        } else {
            return addDigits(sum);
        }
    }
}