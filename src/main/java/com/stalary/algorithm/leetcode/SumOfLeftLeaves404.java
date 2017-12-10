/**
 * @(#)SumOfLeftLeaves404.java, 2017-12-01.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SumOfLeftLeaves404
 *
 * 求二叉树左节点中叶节点的所有和
 * @author lirongqian
 * @since 2017/12/1
 */
public class SumOfLeftLeaves404 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }

    static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }
        if (root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

}