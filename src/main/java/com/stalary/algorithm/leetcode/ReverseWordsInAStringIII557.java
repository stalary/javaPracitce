/**
 * @(#)ReverseWordsInAStringIII557.java, 2017-11-18.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ReverseWordsInAStringIII557
 *
 * 按块逆置
 * @author lirongqian
 * @since 2017/11/18
 */
public class ReverseWordsInAStringIII557 {

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String[] strings = str.split(" ");
        StringBuilder[] temps = new StringBuilder[strings.length];
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            temps[i] = new StringBuilder(strings[i]);
            temps[i].reverse();
            if (i == strings.length - 1) {
                finalStr.append(temps[i]);
            } else {
                finalStr.append(temps[i]).append(" ");
            }
        }
        System.out.println(finalStr);
    }
}