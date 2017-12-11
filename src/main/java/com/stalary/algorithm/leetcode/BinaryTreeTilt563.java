/**
 * @(#)BinaryTreeTilt.java, 2017-12-03.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * BinaryTreeTilt
 *
 * @author lirongqian
 * @since 2017/12/3
 */
public class BinaryTreeTilt563 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        findTilt(node);
        System.out.println(sum);
    }

    static int sum = 0;
    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

}