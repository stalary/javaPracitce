/**
 * @(#)ValidAnagram242.java, 2017-12-05.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ValidAnagram242
 *
 * 输入两个字符串s，t，判断字符串t是否是由s里的字母组成的
 * @author lirongqian
 * @since 2017/12/5
 */
public class ValidAnagram242 {

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char c = t.charAt(i);
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过打表的方法来判断是否t由s组成
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过转化为数组，进行排序后看是否元素相同来判断
     */
    public static boolean isAnagram2(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}