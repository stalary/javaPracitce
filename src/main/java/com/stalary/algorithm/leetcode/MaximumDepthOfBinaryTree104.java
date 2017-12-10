/**
 * @(#)MaximumDepthOfBinaryTree104.java, 2017-11-23.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MaximumDepthOfBinaryTree104
 *
 * 查找二叉树中最长的路径，每次都查找有儿子的子数
 * @author lirongqian
 * @since 2017/11/23
 */
public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}