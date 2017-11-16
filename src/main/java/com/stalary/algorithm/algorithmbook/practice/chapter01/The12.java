/**
 * @(#)The12.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

/**
 * The12
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The12 {

    /**
     * 给出以下表达式的类型和值:
     a. (1 + 2.236)/2
     b. 1 + 2 + 3 + 4.0
     c. 4.1 >= 4
     d. 1 + 2 + "3"
     * @param args
     */
    public static void main(String[] args) {
        // double
        System.out.println(((1 + 2.236) / 2));
        // double
        System.out.println(1 + 2 + 3 + 4.0);
        // boolean
        System.out.println(4.1 >= 4);
        // String
        System.out.println(1 + 2 + "3");
    }
}