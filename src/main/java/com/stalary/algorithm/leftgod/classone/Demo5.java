/**
 * @(#)Demo5.java, 2017-11-10.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leftgod.classone;

import java.util.Random;

/**
 * Demo5
 *
 * @author lirongqian
 * @since 2017/11/10
 */
public class Demo5 {

    /**
     * 随机快速排序
     时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定性。
     * @param args
     */
    public static void main(String[] args) {

        int[] a = new int[]{
                3,2,5,1,4,9
        };
        quickSort(a, 0, a.length - 1);
        System.out.println("after sort");
        for (int out : a) {
            System.out.print(out + " ");
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        Random random = new Random();
        int l = left;
        int r = right;
        int temp = left + random.nextInt(right);
        int finalKey = temp < right ? temp : right;
        int key = a[finalKey];
        while (l < r) {
            while (a[r] >= key && l < r) {
                r--;
            }
            while (a[l] <= key && l < r) {
                l++;
            }
            if(l < r) {
                swap(a, r, l);
            }
        }
        quickSort(a, left, l - 1);
        quickSort(a, l + 1, right);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}