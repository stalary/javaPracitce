/**
 * @(#)The15.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

import java.util.Scanner;

/**
 * The15
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The15 {

    /**
     * 编写一段程序，如果 double 类型的变量 x 和 y 都严格位于 0 和 1 之间则打印 true，否则打印 false。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        if ((x > 0 && x < 1) && (y > 0 && y < 1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}