/**
 * @(#)TwoSum1.java, 2017-12-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum1
 *
 * @author lirongqian
 * @since 22/12/2017
 */
public class TwoSum1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                if (i == map.get(temp)) {
                    continue;
                }
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
        }
        return result;
    }
}