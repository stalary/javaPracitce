/**
 * @(#)NextGreaterElementI496.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NextGreaterElementI496
 *
 * 将第一个数组中的元素去第二个数组中查找，查找是否在后面存在比它小的数
 * @author lirongqian
 * @since 2017/11/21
 */
public class NextGreaterElementI496 {

    public static void main(String[] args) {
        int[] nums1 = {
                4, 1, 2
        };
        int[] nums2 = {
                1, 3, 4, 2
        };
        int[] nums3 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            int temp = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp = j;
                    break;
                }
            }
            for (int j = temp; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    nums3[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                nums3[i] = -1;
            }
        }

        for (int out : nums3) {
            System.out.print(out + " ");
        }
    }

    /**
     * 找出递增子序列即能完成，所以将元素入栈，将比下一个元素小的出栈，存入map中
     *
     * @param findNums
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        // map from x to next greater element of x
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {//1,3,4,2
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }
}