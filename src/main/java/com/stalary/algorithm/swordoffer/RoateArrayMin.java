/**
 * @(#)RoateArrayMin.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * RoateArrayMin
 * <p>
 * 旋转数组是一个排序数组的若干部分被移到末尾，求旋转数组的最小值
 *
 * @author lirongqian
 * @since 2017/12/4
 */
public class RoateArrayMin {

    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 4, 5, 1, 2
        };
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                System.out.println(arr[i + 1]);
            }
        }
    }
}