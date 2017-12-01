/**
 * @(#)SingleNumber136.java, 2017-11-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;

/**
 * SingleNumber136
 *
 * 使用异或来判断一个数组中唯一的不重复的元素
 * @author lirongqian
 * @since 2017/11/22
 */
public class SingleNumber136 {

    public static void main(String[] args) {
        int[] nums = {
                1,2,2,3,1
        };
        System.out.println(singleNumber1(nums));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (int n : nums) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        return 0;
    }
}
