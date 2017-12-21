/**
 * @(#)SetMismatch645.java, 2017-12-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * SetMismatch645
 * <p>
 * 给定一个从1开始递增的数组，找出重复的元素，并输出原本所应该对应的元素
 *
 * @author lirongqian
 * @since 21/12/2017
 */
public class SetMismatch645 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 2, 2
        };
        for (int out : new SetMismatch645().findErrorNums(arr)) {
            System.out.print(out + " ");
        }
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            // 通过正负判断是否为重复出现的数字，省去了Set的使用
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i);
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 大于0代表未遍历到的数字
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }

}