/**
 * @(#)BinaryWatch401.java, 2017-12-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryWatch401
 *
 * 输入二进制手表上led灯亮的数目，求出可能的时间
 * @author lirongqian
 * @since 2017/12/9
 */
public class BinaryWatch401 {

    public static void main(String[] args) {
        List<String> list = readBinaryWatch(1);
        for (String out : list) {
            System.out.println(out);
        }
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}