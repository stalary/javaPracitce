/**
 * @(#)PalindromicSubstrings647.java, 2018-01-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * PalindromicSubstrings647
 *
 * 求出字符串中回文字串的数量
 * @author lirongqian
 * @since 2018/01/06
 */
public class PalindromicSubstrings647 {

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings647().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            help(s, i, i);
            help(s, i, i + 1);
        }
        return count;
    }

    int count = 0;
    public void help(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}