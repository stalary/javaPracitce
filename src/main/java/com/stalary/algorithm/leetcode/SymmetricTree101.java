/**
 * @(#)SymmetricTree101.java, 2017-12-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SymmetricTree101
 *
 * 判断一颗二叉树是否是对称的
 * @author lirongqian
 * @since 22/12/2017
 */
public class SymmetricTree101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    /**
     * 对称的关系为左儿子的右儿子与右儿子的左儿子相等，左儿子的左儿子与右儿子的右儿子相等
     * @param left
     * @param right
     * @return
     */
    public boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }

}