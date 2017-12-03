/**
 * @(#)FirstUniqueCharacterInAString.java, 2017-12-03.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;

/**
 * FirstUniqueCharacterInAString
 *
 * 输入一个字符串，查找第一个不重复的字符，并输出其下标
 * @author lirongqian
 * @since 2017/12/3
 */
public class FirstUniqueCharacterInAString387 {

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                map.put(a, map.get(s.charAt(i)) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.get(a) == 1) {
                return i;
            }
        }
        return -1;
    }
}