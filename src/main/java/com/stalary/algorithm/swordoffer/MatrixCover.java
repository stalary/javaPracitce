/**
 * @(#)MatrixCover.java, 2017-12-05.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * MatrixCover
 *
 * 给一个2*1的矩阵，可以横着放或者竖着放，然后给定2*n的矩阵，求一共有多少种方法
 * 通过找规律可以发现也是一个斐波那契数列
 * @author lirongqian
 * @since 2017/12/5
 */
public class MatrixCover {

    public static void main(String[] args) {
        System.out.println(RectCover(3));
    }

    public static int RectCover(int target) {
        if (target <= 1) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[target];
    }
}