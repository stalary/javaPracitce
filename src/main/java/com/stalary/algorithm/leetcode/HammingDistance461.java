/**
 * @(#)HammingDistance.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Scanner;

/**
 * HammingDistance
 *
 * 求两个数字的异或后一共有多少个1
 * @author lirongqian
 * @since 2017/11/9
 */
public class HammingDistance461 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(Integer.bitCount(a ^ b));
    }
}