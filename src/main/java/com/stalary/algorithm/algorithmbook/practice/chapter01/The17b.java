/**
 * @(#)The17b.java, 2017-11-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.algorithmbook.practice.chapter01;

/**
 * The17b
 *
 * @author lirongqian
 * @since 2017/11/9
 */
public class The17b {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println(sum);

    }
}