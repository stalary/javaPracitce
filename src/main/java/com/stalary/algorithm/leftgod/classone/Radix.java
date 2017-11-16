/**
 * @(#)Radix.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leftgod.classone;

import java.util.Scanner;

/**
 * Radix
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class Radix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if (m >= 0) {
            System.out.println(Integer.toString(m, n).toUpperCase());
        } else {
            System.out.println("-" + Integer.toString(Math.abs(m), n).toUpperCase());
        }
    }

}