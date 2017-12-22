/**
 * @(#)SearchInsertPosition35.java, 2017-12-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SearchInsertPosition35
 *
 * 给定一个排好序的数组，输入一个目标值，若能找到，则返回下标，如果找不到，则返回可插入的下标靠
 * @author lirongqian
 * @since 22/12/2017
 */
public class SearchInsertPosition35 {

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition35().searchInsert(new int[] {
                1,3,5,6
        }, 0));
    }

    /**
     * 二分查找的变形，当未找到是不返回-1，而是返回start
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

}