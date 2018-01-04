/**
 * @(#)BalancedBinaryTree110.java, 2018-01-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * BalancedBinaryTree110
 *
 * 判断一颗二叉树是不是平衡二叉树
 * @author lirongqian
 * @since 2018/01/04
 */
public class BalancedBinaryTree110 {

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}