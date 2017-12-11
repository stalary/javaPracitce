/**
 * @(#)Base7504.java, 2017-12-11.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * Base7504
 * <p>
 * 将十进制转化为七进制
 *
 * @author lirongqian
 * @since 2017/12/11
 */
public class Base7504 {

    public static void main(String[] args) {
        System.out.println(convertTo7(100));
    }

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public static String convertTo7(int num) {
        if (num < 0) {
            return '-' + convertTo7(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertTo7(num / 7) + num % 7;
    }
}