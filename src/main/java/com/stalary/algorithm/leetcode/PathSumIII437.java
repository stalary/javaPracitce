/**
 * @(#)PathSumIII437.java, 2017-12-19.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * PathSumIII437
 *
 * 给定一个二叉树和一个sum，求出满足和为sum的路径的数量
 * @author lirongqian
 * @since 19/12/2017
 */
public class PathSumIII437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 查找root的路径，然后递归的查找左儿子和右儿子
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        // 如果如果结点的值等于sum，则直接加1，否则去左儿子和右儿子查找sum-结点的值的结点
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}