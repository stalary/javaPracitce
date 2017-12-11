/**
 * @(#)InvertBinaryTree226.java, 2017-11-23.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * InvertBinaryTree226
 *
 * 交换两颗二叉树的
 * @author lirongqian
 * @since 2017/11/23
 */
public class InvertBinaryTree226 {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node;
        node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

}