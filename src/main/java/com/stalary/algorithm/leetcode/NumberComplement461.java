/**
 * @(#)NumberComplement461.java, 2017-11-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Scanner;

/**
 * NumberComplement461
 *
 * 求一个数取反后的十进制的值
 * @author lirongqian
 * @since 2017/11/17
 */
public class NumberComplement461 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String str = Integer.toBinaryString(a);
        int len = str.length();
        String str1 = Integer.toBinaryString(~a);
        String str2 = str1.substring(str1.length() - len);
        System.out.println(Integer.parseInt(Integer.toString(Integer.parseInt(str2, 2), 10),10));
    }
}