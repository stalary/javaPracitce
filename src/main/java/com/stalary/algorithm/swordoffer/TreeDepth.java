/**
 * @(#)TreeDepth.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * TreeDepth
 * 求一颗二叉树的深度
 * @author lirongqian
 * @since 27/12/2017
 */
public class TreeDepth {

    public static void main(String[] args) {

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.right), TreeDepth(root.left));
    }
}