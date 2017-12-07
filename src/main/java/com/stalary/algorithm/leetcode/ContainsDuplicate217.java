/**
 * @(#)ContainsDuplicate217.java, 2017-12-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * ContainsDuplicate217
 *
 * 如果数组中有重复元素则返回true
 * @author lirongqian
 * @since 2017/12/7
 */
public class ContainsDuplicate217 {

    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
}