/**
 * @(#)MergeTwoBinaryTrees.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * MergeTwoBinaryTrees617
 *
 * 合并两颗二叉树的值，通过递归进行每一层的合并
 * @author lirongqian
 * @since 2017/11/15
 */
public class MergeTwoBinaryTrees617 {

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


}