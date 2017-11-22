/**
 * @(#)LongestUncommonSubsequenceI521.java, 2017-11-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * LongestUncommonSubsequenceI521
 *
 * @author lirongqian
 * @since 2017/11/22
 */
public class LongestUncommonSubsequenceI521 {

    public static void main(String[] args) {
        String str1 = "aba";
        String str2 = "cdc";
        System.out.println(str1.equals(str2) ? -1 : Math.max(str1.length(), str2.length()));
    }
}