/**
 * @(#)MissingNumber268.java, 2017-12-10.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * MissingNumber268
 *
 * 输入一个0～n的数组，查找缺少的元素
 * @author lirongqian
 * @since 2017/12/10
 */
public class MissingNumber268 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0
        };
        System.out.println(missingNumber1(nums));
    }

    /**
     * 使用set将数组中出现的元素存储，然后再进行一次循环，比较数组长度+1大小，返回不存在的元素
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 使用bit来进行判断缺少的元素
     */
    public static int missingNumber1(int[] nums) {

        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}