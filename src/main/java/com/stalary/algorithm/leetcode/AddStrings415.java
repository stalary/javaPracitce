/**
 * @(#)AddStrings415.java, 2017-12-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * AddStrings415
 *
 * 将两个字符串的数值相加，不能使用BigInteger和整形转化
 * @author lirongqian
 * @since 2017/12/15
 */
public class AddStrings415 {

    public static void main(String[] args) {
        AddStrings415 a = new AddStrings415();
        System.out.println(a.addStrings("98", "9"));
    }

    /**
     * 从右到左进行求和，carry是计算出进位的数字
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}