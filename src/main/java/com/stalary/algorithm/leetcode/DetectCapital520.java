/**
 * @(#)DetectCapital520.java, 2017-11-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.stream.Stream;

/**
 * DetectCapital520
 * 仅在全为大写字母或者全为小写字母，或者仅首字母大写时返回true
 * @author lirongqian
 * @since 2017/11/24
 */
public class DetectCapital520 {

    public static void main(String[] args) {
        String str = "USA";
        System.out.println(detectCapitalUse1(str));
    }

    public static boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }

    /**
     * 可以巧妙的运用大小写转化来进行判断
     * @param word
     * @return
     */
    public static boolean detectCapitalUse1(String word) {
        return word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()) || Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
    }
}