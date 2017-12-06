/**
 * @(#)RelativeRanks506.java, 2017-12-06.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * RelativeRanks506
 *
 * 给出一个数组，代表每个运动员的成绩，对运动员的成绩进行排序，前三面发奖牌，后面的写名次
 * @author lirongqian
 * @since 2017/12/6
 */
public class RelativeRanks506 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                10, 3, 8, 9, 4
        };
        for (String str : findRelativeRanks(nums)) {
            System.out.println(str);
        }
    }

    /**
     * 用hashMap存储每个运动员的初始位置，然后进行排序，按照名次赋值到字符串中
     * @param nums
     * @return
     */
    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        quickSort(nums);
        strings[map.get(nums[0])] = "Gold Medal";
        if (len > 1) {
            strings[map.get(nums[1])] = "Silver Medal";
        }
        if (len > 2) {
            strings[map.get(nums[2])] = "Bronze Medal";
        }
        for (int i = 3; i < len; i++) {
            strings[map.get(nums[i])] = String.valueOf(i + 1);
        }
        return strings;
    }

    public static void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    public static void quick(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int key = nums[right];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[l] >= key) {
                l++;
            }
            while (l < r && nums[r] <= key) {
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        nums[right] = nums[l];
        nums[l] = key;
        quick(nums, left, l - 1);
        quick(nums, l + 1, right);
    }

}