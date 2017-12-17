/**
 * @(#)LongestHarmoniousSubsequence594.java, 2017-12-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * LongestHarmoniousSubsequence594
 *
 * 给定一个数组，求出数组中一组相差值为1的最大数量
 * @author lirongqian
 * @since 2017/12/17
 */
public class LongestHarmoniousSubsequence594 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 3, 2, 2, 5, 2, 3, 7
        };
        System.out.println(new LongestHarmoniousSubsequence594().findLHS(nums));
    }

    /**
     * 使用map存储数字和出现的次数，然后算出最大值
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int out : nums) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                max = Math.max(max, map.get(list.get(i)) + map.get(list.get(i - 1)));
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}