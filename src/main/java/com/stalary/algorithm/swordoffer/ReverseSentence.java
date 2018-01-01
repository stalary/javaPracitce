/**
 * @(#)ReverseSentence.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * ReverseSentence
 * 反转字符串student. a am I-》I am a student.
 * @author lirongqian
 * @since 31/12/2017
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence(" "));
    }

    public String ReverseSentence(String str) {
        if ("".equals(str.trim())) {
            return str;
        }
        String[] strings = str.split(" ");
        String s = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i != 0) {
                s += strings[i] + " ";
            } else {
                s += strings[i];
            }
        }
        return s;
    }
}