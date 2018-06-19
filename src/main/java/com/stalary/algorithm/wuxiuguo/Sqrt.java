/**
 * @(#)Sqrt.java, 2018-06-19.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * Sqrt
 *
 * @author lirongqian
 * @since 2018/06/19
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(getSqrt(3));
    }

    public static int getSqrt(int num) {
        for (int i = 1; i < num; i++) {
            int square = i * i;
            if (square == num) {
                return i;
            } else if (square > num) {
                return i - 1;
            }
        }
        return -1;
    }
}