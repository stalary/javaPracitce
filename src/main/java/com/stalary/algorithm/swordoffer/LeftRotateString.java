/**
 * @(#)LeftRotateString.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * LeftRotateString
 *
 * @author lirongqian
 * @since 31/12/2017
 */
public class LeftRotateString {

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString1("abcXYZdef", 3));
    }

    public String LeftRotateString(String str,int n) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        return str2 + str1;
    }

    public String LeftRotateString1(String str,int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        str += str;
        return str.substring(n, len + n);
    }
}