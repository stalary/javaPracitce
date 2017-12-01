/**
 * @(#)RansomNote383.java, 2017-12-01.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;

/**
 * RansomNote383
 *
 * 求第一个字符串是否可以由第二个字符串组成，可以使用hashMap来统计每个元素的数量以及是否出现
 * @author lirongqian
 * @since 2017/12/1
 */
public class RansomNote383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)  {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0 ; i < ransomNote.length(); i++) {
            if (map.get(ransomNote.charAt(i)) == null || map.get(ransomNote.charAt(i)) < 1) {
                return false;
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }
}