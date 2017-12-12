/**
 * @(#)ReverseStringII541.java, 2017-12-12.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ReverseStringII541
 *
 * 输入一个字符串s，输入一k，截取每2*k个元素进行分组，并对前k个元素依次反转
 * @author lirongqian
 * @since 2017/12/12
 */
public class ReverseStringII541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 8));
    }

    /**
     * 注意：
     * 当长度小于k时则全部反转，若大于k小于2k的部分，则反转前k的元素，如果还有少于k个字符则不尽兴反转
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        int len = s.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp;
        while (index < len) {
            String str = s.substring(index, index + k > len ? len : index + k);
            temp = new StringBuilder(str).reverse();
            sb.append(temp).append(s.substring(index + k > len ? len : index + k, index + 2 * k > len ? len : index + 2 * k));
            index += 2 * k;
        }
        return sb.toString();
    }
}