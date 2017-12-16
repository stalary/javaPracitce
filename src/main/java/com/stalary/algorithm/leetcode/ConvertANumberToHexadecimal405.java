/**
 * @(#)ConvertANumberToHexadecimal405.java, 2017-12-16.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ConvertANumberToHexadecimal405
 *
 * @author lirongqian
 * @since 2017/12/16
 */
public class ConvertANumberToHexadecimal405 {

    public static void main(String[] args) {
        ConvertANumberToHexadecimal405 c = new ConvertANumberToHexadecimal405();
        System.out.println(c.toHex(26));
    }
    char[] map = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    public String toHex(int num) {
       if (num == 0) {
           return "0";
       }
       String result = "";
       while (num != 0) {
           result = map[num & 15] + result;
           num = num >>> 4;
       }
       return result;
    }
}