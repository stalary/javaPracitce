/**
 * @(#)Demo4.java, 2017-11-10.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leftgod.classone;

import java.util.Arrays;

/**
 * Demo4
 *
 * @author lirongqian
 * @since 2017/11/10
 */
public class Demo4 {

    /**
     * 一个数组记为A，有序;另一个数组记为B，无序; 请打印B中的所有不在A中的数;A数组长度为N，B数组长度为M;
     * 实现时间复杂度O(M*logN)
     * 课前思路：二分法
     * @param args
     */
    public static void main(String[] args) {

        int[] a = new int[] {
                1,2,3,4,5,6
        };
        int[] b = new int[] {
                2,4,9,1,12
        };

        find(a,b);
    }

    private static void find(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (Arrays.binarySearch(a, b[i]) < 0) {
                System.out.println(b[i]);
            }
        }
    }
}