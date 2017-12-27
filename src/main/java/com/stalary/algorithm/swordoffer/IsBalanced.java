/**
 * @(#)IsBalanced.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * IsBalanced
 *
 * 判断一颗二叉树是不是平衡二叉树
 * @author lirongqian
 * @since 27/12/2017
 */
public class IsBalanced {

    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
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
        if (root.left != null) {
            if (root.left.val >= root.val) {
               flag = false;
            }
        }
        if (root.right != null) {
            if (root.right.val < root.val) {
                flag = false;
            }
        }
        return right > left ? right + 1 : left + 1;
    }
}