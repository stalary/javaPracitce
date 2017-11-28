/**
 * @(#)ConstructTheRectangle492.java, 2017-11-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ConstructTheRectangle492
 * <p>
 * 求一个数字由两个数字相乘的数组，并且两个数字是最接近的
 *
 * @author lirongqian
 * @since 2017/11/28
 */
public class ConstructTheRectangle492 {

    public static void main(String[] args) {
        System.out.println(constructRectangle(10000000)[0]);
        System.out.println(constructRectangle(10000000)[1]);
    }

    public static int[] constructRectangle(int area) {
        int[] a = new int[2];
        int a1 = (int) Math.sqrt(area);
        while (area % a1 != 0) {
            a1++;
        }
        a[0] = Math.max(a1, area / a1);
        a[1] = Math.min(a1, area / a1);
        return a;
    }

}