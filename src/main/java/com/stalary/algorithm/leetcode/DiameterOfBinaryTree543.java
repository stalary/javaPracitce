/**
 * @(#)DiameterOfBinaryTree543.java, 2017-12-10.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * DiameterOfBinaryTree543
 *
 * 求二叉树的最长路径
 * 思路：
 * 递归的遍历二叉树的左儿子和右儿子，并对路径求和，每次求最大的路径
 * @author lirongqian
 * @since 2017/12/10
 */
public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}