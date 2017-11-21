/**
 * @(#)NextGreaterElementI496.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;

/**
 * NextGreaterElementI496
 *
 * @author lirongqian
 * @since 2017/11/21
 */
public class NextGreaterElementI496 {

    public static void main(String[] args) {
        int[] nums1 = {
                1, 3, 5, 2, 4
        };
        int[] nums2 = {
                6, 5, 4, 3, 2, 1, 7
        };
        int[] nums3 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            int temp = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp = j;
                    break;
                }
            }
            for (int j = temp; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    nums3[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                nums3[i] = -1;
            }
        }

        for (int out : nums3) {
            System.out.print(out + " ");
        }
    }

    public static int search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}