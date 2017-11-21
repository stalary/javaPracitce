/**
 * @(#)Demo1.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leftgod.classtwo;

/**
 * Demo1
 *
 * @author lirongqian
 * @since 2017/11/21
 */
public class Demo1 {

    private static int[]  a = new int[10];

    private static int index = 0;

    public static boolean isEmpty() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFull() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean enqueue(Integer element) {
        if (isFull()) {
            return false;
        } else {
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] != 0) {
                    a[i + 1] = a[i];
                }
            }
        }
        return true;
    }

    public static int dequeue() {
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] != 0) {
                    return a[i];
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(a.length);
    }
}