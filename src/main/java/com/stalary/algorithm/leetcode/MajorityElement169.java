/**
 * @(#)MajorityElement169.java, 2017-12-01.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;

/**
 * MajorityElement169
 *
 * @author lirongqian
 * @since 2017/12/1
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                6, 5, 5
        };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            if (map.get(n) > nums.length / 2) {
                return n;
            }
        }
        return 0;
    }
}