/**
 * @(#)AdjustArray.java, 2017-12-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * AdjustArray
 *
 * @author lirongqian
 * @since 2017/12/7
 */
public class AdjustArray {

    public static void main(String[] args) {
        int[] arr = new int[] {
                1, 2, 3, 9, 4
        };
        reOrderArray1(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void reOrderArray(int [] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int n : array) {
            if ((n & 1) == 1) {
                list.add(n);
            }
        }
        for (int n : array) {
            if ((n & 1) == 0) {
                list.add(n);
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    /**
     * 利用类似于插入排序的思想，如果存在偶数在奇数后面，就一直向前移动
     * @param array
     */
    public static void reOrderArray1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] % 2 == 1 && array[j - 1] % 2 == 0; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }
}