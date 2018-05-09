/**
 * @(#)Meituan1.java, 2018-03-22.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.interview;

/**
 * Meituan1
 *
 * @author lirongqian
 * @since 2018/03/22
 */

import java.util.Scanner;

public class Meituan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(Meituan1.getStringDis(s, t));
    }

    public static int getStringDis(String s, String t) {
        int m = 0;  //统计模式串相邻的字符总长度
        int n = 0;
        int sum = 0; //记录放回的字符串长度
        int sLen = s.length();
        int tLen = t.length();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        //对模式串统计
        for (int i = 0; i < tLen - 1; i++) {
            if (cht[i] != cht[i + 1]) {
                ++m;
            }
        }
        //对子、母串前tLen长度统计
        for (int j = 0; j < tLen; j++) {
            if (chs[j] != cht[j]) {
                ++n;
            }
        }
        //统计第一次匹配总共距离
        sum += n;
        for (int k = tLen; k < sLen; k++) {
            // 当无法和第一位进行匹配时即减去1
            if (chs[k - tLen] != cht[0]) {
                n -= 1;
            }
            // 
            if (chs[k] != cht[tLen - 1]) {
                n = n + m + 1;
            } else {
                n = n + m;
            }
            //防止统计越界
            n = n % (tLen + 1);
            sum += n;

        }
        return sum;

    }

}