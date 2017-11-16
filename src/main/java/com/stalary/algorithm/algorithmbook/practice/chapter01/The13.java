/**
 * @(#)The13.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

import java.util.Scanner;

/**
 * The13
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The13 {

    /**
     * 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印 equal，否则打印 not
     equal。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a == b && a == c) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}