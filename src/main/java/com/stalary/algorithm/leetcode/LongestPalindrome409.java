/**
 * @(#)LongestPalindrome409.java, 2017-12-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestPalindrome409
 *
 * 给定一个字符串，求出字符串所能拼成的最长的回文串
 * @author lirongqian
 * @since 2017/12/9
 */
public class LongestPalindrome409 {

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int sum = 0;
        boolean flag = false;
        for (char a : map.keySet()) {
            if ((map.get(a) & 1) == 1) {
                sum += map.get(a) - 1;
                flag = true;
            } else {
                sum += map.get(a);
            }
        }
        if (flag) {
            sum++;
        }
        return sum;
    }
}