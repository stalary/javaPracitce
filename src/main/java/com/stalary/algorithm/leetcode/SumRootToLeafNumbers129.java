/**
 * @(#)SumRootToLeafNumbers129.java, 2018-01-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * SumRootToLeafNumbers129
 *
 * 求一个二叉树所有路径和
 *        1
 *      2   3
 *   12+13=25
 * @author lirongqian
 * @since 2018/01/04
 */
public class SumRootToLeafNumbers129 {

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return help(root, 0);
    }

    public int help(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return sum * 10 + root.val;
        }
        return help(root.right, sum * 10 + root.val) + help(root.left, sum * 10 + root.val);
    }
}