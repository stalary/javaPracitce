/**
 * @(#)HouseRobberIII337.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * HouseRobberIII337
 *
 * 对二叉树中的结点求和，求最大值，不能计算相连的结点
 * @author lirongqian
 * @since 31/12/2017
 */
public class HouseRobberIII337 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.right != null) {
            val += rob(root.right.right) + rob(root.right.left);
        }
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}