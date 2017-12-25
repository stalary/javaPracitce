/**
 * @(#)MaximumBinaryTree654.java, 2017-12-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MaximumBinaryTree654
 *
 * @author lirongqian
 * @since 25/12/2017
 */
public class MaximumBinaryTree654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = help(nums, start, max - 1);
        root.right = help(nums, max + 1, end);
        return root;
    }
}