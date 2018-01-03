/**
 * @(#)StrToInt.java, 2018-01-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * StrToInt
 *
 * @author lirongqian
 * @since 03/01/2018
 */
public class StrToInt {

    public static void main(String[] args) {
        int a = '9';
        System.out.println(a);
    }

    /**
     * '0':48,'9':57，所以每个字符的返回需要在48-57之间
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        boolean symbol = true;
        char[] chars = str.toCharArray();
        // 判断正负号
        int index = 0;
        if (chars[0] == '-') {
            symbol = false;
            index++;
        } else if (chars[0] == '+') {
            index++;
        }
        int sum = 0;
        for (int i = index; i < str.length(); i++) {
            if (chars[i] > 57 || chars[i] < 48) {
                return 0;
            } else {
                // 求和-》321-》 3->30+2->320+1=321
                sum = sum * 10 + chars[i] - 48;
            }
        }
        return symbol ? sum : -1 * sum;
    }
}