/**
 * @(#)UglyNumber263.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * UglyNumber263
 * <p>
 * 判断一个数是不是丑数，丑数是由2，3，5组成的质数
 *
 * @author lirongqian
 * @since 24/12/2017
 */
public class UglyNumber263 {

    public static void main(String[] args) {
        System.out.println(new UglyNumber263().isUgly(7));
    }

    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                return false;
            }
        }
        return num == 1;
    }

    /**
     * 因为能被2，3，5整除，所以能被2，3，4，5的都是丑数w
     * @param num
     * @return
     */
    public boolean isUgly1(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}