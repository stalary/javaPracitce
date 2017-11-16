/**
 * @(#)The17c.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

/**
 * The17c
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The17c {

    public static void main(String[] args) {
        int sum = 0;
        // 2^10为1024，所以为1000 * 10
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}