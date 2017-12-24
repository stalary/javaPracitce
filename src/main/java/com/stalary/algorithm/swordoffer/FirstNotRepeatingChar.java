/**
 * @(#)FirstNotRepeatingChar.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashMap;
import java.util.Map;


/**
 * FirstNotRepeatingChar
 * <p>
 * 找到第一个只出现一次的字符，并返回他的位置
 *
 * @author lirongqian
 * @since 24/12/2017
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar1("abaca"));
    }

    /**
     * 使用一个map就可以判断出是否第一次出现，然后第二次遍历找到下标。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char temp = str.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 首先创建一个以26的字母的ascii码下标的数组
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar1(String str) {
        char[] c = str.toCharArray();
        int[] a = new int['z' + 1];
        for (char d : c) {
            a[d]++;
        }
        for (int i = 0; i < c.length; i++) {
            if (a[c[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

}