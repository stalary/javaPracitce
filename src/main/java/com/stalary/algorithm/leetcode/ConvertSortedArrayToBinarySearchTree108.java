/**
 * @(#)ConvertSortedArrayToBinarySearchTree108.java, 2017-12-12.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import com.sun.deploy.panel.TreeEditors;

/**
 * ConvertSortedArrayToBinarySearchTree108
 *
 * @author lirongqian
 * @since 2017/12/12
 */
public class ConvertSortedArrayToBinarySearchTree108 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -10, -3, 0, 5, 9
        };
        TreeNode node = sortedArrayToBST(nums);
        printTree(node);
    }

    public static void printTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    public static TreeNode help(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (high + low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, low, mid - 1);
        node.right = help(nums, mid + 1, high);
        return node;
    }
}