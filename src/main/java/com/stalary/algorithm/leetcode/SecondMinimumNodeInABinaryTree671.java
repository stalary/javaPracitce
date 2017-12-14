/**
 * @(#)SecondMinimumNodeInABinaryTree671.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SecondMinimumNodeInABinaryTree671
 *
 * 求二叉树中第二小的数字
 * @author lirongqian
 * @since 2017/12/14
 */
public class SecondMinimumNodeInABinaryTree671 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        SecondMinimumNodeInABinaryTree671 s = new SecondMinimumNodeInABinaryTree671();
        System.out.println(s.findSecondMinimumValue(root));

    }

    int min = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root != null) {
            if (root.val <= min) {
                min = root.val;
            } else {
                if (root.val < second) {
                    second = root.val;
                }
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return second == Integer.MAX_VALUE ? -1 : second;
    }
}