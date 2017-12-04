/**
 * @(#)SameTree100.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SameTree100
 *
 * 判断两棵二叉树是否相同
 * @author lirongqian
 * @since 2017/12/4
 */
public class SameTree100 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(2);
        System.out.println(isSameTree(node1, node2));
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}