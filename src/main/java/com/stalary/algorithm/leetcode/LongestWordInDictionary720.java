/**
 * @(#)LongestWordInDictionary720.java, 2017-12-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * LongestWordInDictionary720
 *
 * @author lirongqian
 * @since 2017/12/17
 */
public class LongestWordInDictionary720 {

    public static void main(String[] args) {
        String[] words = new String[]{
                "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"
        };
        System.out.println(new LongestWordInDictionary720().longestWord(words));
        for (String out : words) {
            System.out.print(out + " ");
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }

}