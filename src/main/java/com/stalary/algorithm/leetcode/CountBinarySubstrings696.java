/**
 * @(#)CountBinarySubstrings696.java, 2017-11-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * CountBinarySubstrings696
 * <p>
 * 求出子串中01数量相同并且连续的数量
 *
 * @author lirongqian
 * @since 2017/11/24
 */
public class CountBinarySubstrings696 {

    public static void main(String[] args) {
        String str = "00110011";
        System.out.println(countBinarySubstrings(str));
    }

    /**
     * 前后元素相同时+1，不同时将相同的数量暂存，然后归1，再进行查找，当相同的数量相同时即++
     *
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curRunLength++;
            } else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) {
                res++;
            }
        }
        return res;
    }
}