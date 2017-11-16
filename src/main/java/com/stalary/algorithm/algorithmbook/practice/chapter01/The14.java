/**
 * @(#)The14.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

/**
 * The14
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The14 {

    /**
     * 下列语句各有什么问题(如果有的话)?
     a. if (a > b) then c = 0;  java中没有then
     b. if a > b { c = 0; }     if后面没有小括号
     c. if (a > b) c = 0;       if后面没有大括号
     d. if (a > b) c = 0 else b = 0;   c = 0后面没有;
     * @param args
     */
    public static void main(String[] args) {

        int a = 0, b = 0, c = 0;
        if (a > b)
            c = 0;
        else b = 0;
    }
}