/**
 * @(#)The1.java, 2017-11-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * The1
 *
 * 找出1-n范围的数组中的重复元素，通过set进行查找即可
 * @author lirongqian
 * @since 2017/11/26
 */
public class The1 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                2, 3, 1, 0, 2, 5, 3
        };
        int[] duplication = new int[1];
        System.out.println(judgeNoSpace(arr, arr.length));
        System.out.println(duplication[0]);
    }

    public static boolean judge(int[] arr, int len, int[] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(arr[i])) {
                duplication[0] = arr[i];
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }

    /**
     * 不使用辅助空间，来查找重复的数字
     * 思路：利用二分的思路，每次判断一定范围内数字出现的次数，若次数大于范围，则代表有重复的数字
     * @return
     */
    public static int judgeNoSpace(int[] numbers, int length) {
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 计算范围内数字的数量
     */
    public static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }
}