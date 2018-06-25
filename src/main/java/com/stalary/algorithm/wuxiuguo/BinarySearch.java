/**
 * @(#)BinarySearch.java, 2018-06-23.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * BinarySearch
 *
 * @author lirongqian
 * @since 2018/06/23
 */
public class BinarySearch {

    public static int search(int key, int[] a) {

        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < a[mid]) {
                end = mid - 1;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}