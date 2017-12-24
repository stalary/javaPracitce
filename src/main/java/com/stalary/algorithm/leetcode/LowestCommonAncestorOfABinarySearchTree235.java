/**
 * @(#)LowestCommonAncestorOfABinarySearchTree235.java, 2017-12-23.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * LowestCommonAncestorOfABinarySearchTree235
 *
 * 找出二叉搜索树中的最小公共祖先
 * @author lirongqian
 * @since 23/12/2017
 */
public class LowestCommonAncestorOfABinarySearchTree235 {

    public static void main(String[] args) {

    }

    /**
     * 因为如果不是分别存在于根的左右两边，那么两个结点的值相乘一点大于0
     * 所以当大于零时，循环的找到最低的公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}