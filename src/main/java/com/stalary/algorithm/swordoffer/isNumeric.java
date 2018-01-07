/**
 * @(#)isNumeric.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * isNumeric
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class isNumeric {

    public static void main(String[] args) {
        System.out.println(new isNumeric().isNumeric("100".toCharArray()));
    }

    private int inx;

    /**
     * .12 1.也是数字
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        inx = 0;
        boolean flag = scanInteger(str);
        //判断小数部分
        if (inx < str.length && str[inx] == '.') {
            inx = inx + 1;
            flag = scanUInteger(str) || flag;     //解释a,见代码下方
        }
        //判断指数部分
        if (inx < str.length && (str[inx] == 'e' || str[inx] == 'E')) {
            inx = inx + 1;
            flag = flag && scanInteger(str);
        }
        return flag && inx >= str.length;
    }

    //判断是否是整数
    public boolean scanInteger(char[] str) {
        if (inx < str.length && (str[inx] == '+' || str[inx] == '-')) {
            inx = inx + 1;
        }
        return scanUInteger(str);
    }

    //判断是否是无符号整数
    public boolean scanUInteger(char[] str) {
        int inx1 = inx;
        while (inx < str.length && str[inx] >= '0' && str[inx] <= '9') {
            inx = inx + 1;
        }
        return inx > inx1;
    }
}