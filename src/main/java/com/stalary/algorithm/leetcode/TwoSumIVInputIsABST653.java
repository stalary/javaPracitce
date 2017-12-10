/**
 * @(#)TwoSumIVInputIsABST653.java, 2017-11-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;


import java.util.HashSet;

/**
 * TwoSumIVInputIsABST653
 *
 * 查找一颗二叉搜索树中两个元素相加能否等于查找值key
 * 用set存入元素，然后遍历每个节点，查找是否存在key-root.val的值
 * @author lirongqian
 * @since 2017/11/26
 */
public class TwoSumIVInputIsABST653 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(findTarget(root, 9));
    }

    public static boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public static boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}