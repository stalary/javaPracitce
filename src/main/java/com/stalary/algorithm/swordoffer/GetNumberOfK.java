/**
 * @(#)GetNumberOfK.java, 2017-12-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * GetNumberOfK
 * <p>
 * 统计一个数字在排序数组中出现的次数
 *
 * @author lirongqian
 * @since 25/12/2017
 */
public class GetNumberOfK {

    public static void main(String[] args) {

    }


    /**
     * 使用map进行统计
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int out : array) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        if (map.get(k) == null) {
            return 0;
        } else {
            return map.get(k);
        }
    }

    /**
     * 使用二分查找的思想，因为是排好序的数组，所以只需要找到开始和结束的点就可以求出出现的次数
     */
    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int first = getFirstK(array, k, 0, length - 1);
        int last = getLastK(array, k, 0, length - 1);
        if (first != -1 && last != -1) {
            return last - first + 1;
        }
        return 0;
    }


    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
            // 当大于零时即继续往前查找
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    private int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
                // 当小于长度时，继续往后查找
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}