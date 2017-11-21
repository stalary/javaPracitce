/**
 * @(#)TrimBinarySearchTree669.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * TrimBinarySearchTree669
 *
 * 去掉二叉搜索树中不在l-r范围内的元素，hint：二叉搜索树的左子树一定小于根，右子树大于根
 * 所以当值小于范围时，就去右子树进行查找，大于范围时就去左子树进行查找
 * @author lirongqian
 * @since 2017/11/21
 */
public class TrimBinarySearchTree669 {

    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
       if (null == root) {
           return null;
       }
       if (root.val < L) {
           return trimBST(root.right, L, R);
       }
       if (root.val > R) {
           return trimBST(root.left, L, R);
       }
       root.left = trimBST(root.left, L, R);
       root.right = trimBST(root.right, L, R);

       return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}