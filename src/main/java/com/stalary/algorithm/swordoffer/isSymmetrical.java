/**
 * @(#)isSymmetrical.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * isSymmetrical
 *
 * 判断一颗二叉树是否对称
 * @author lirongqian
 * @since 2018/01/07
 */
public class isSymmetrical {

    public static void main(String[] args) {

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return help(pRoot.left, pRoot.right);
    }

    public boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return help(left.right,right.left) && help(left.left, right.right);
    }
}