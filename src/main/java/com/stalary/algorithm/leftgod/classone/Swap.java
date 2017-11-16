/**
 * @(#)Swap.java, 2017-11-11.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leftgod.classone;

/**
 * Swap
 *
 * @author lirongqian
 * @since 2017/11/11
 */
public class Swap {

    public static void main(String[] args) {
        int[] a = new int[] {
                2,3,1,5,4
        };
        swap(a, 0, 1);
        for (int out : a) {
            System.out.println(out);
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}