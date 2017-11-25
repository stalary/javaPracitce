/**
 * @(#)FindAllNumbersDisappearedInAnArray448.java, 2017-11-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * FindAllNumbersDisappearedInAnArray448
 *
 * 在0-n中找到数组中不存在的元素，我们可以顺序查找，将每次找到的元素对应的下标设为负数
 * 当第二次遍历时，将正数存入list中返回
 * @author lirongqian
 * @since 2017/11/25
 */
public class FindAllNumbersDisappearedInAnArray448 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        };
        System.out.println(findDisappearedNumbers(nums));
    }

    /**
     * 使用类似于打表的方法，将出现过的数字作为下标存入，设为负数
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}