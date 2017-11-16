/**
 * @(#)The16.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

/**
 * The16
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The16 {

    /**
     * 下面这段程序会打印出什么?
     int f = 0;
     int g = 1;
     for (int i = 0; i <= 15; i++)
     {
     StdOut.println(f);
     f = f + g;
     g = f - g;
     }
     * @param args
     */
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;

        }
    }
}