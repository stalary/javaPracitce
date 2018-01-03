/**
 * @(#)MaximumWidthOfBinaryTree662.java, 2018-01-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * MaximumWidthOfBinaryTree662
 * <p>
 * 求一个二叉树的最大宽度
 *
 * @author lirongqian
 * @since 03/01/2018
 */
public class MaximumWidthOfBinaryTree662 {

    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    /**
     * 结点从1开始
     * 找到最左和最右的结点的索引，最大宽度即为end[level] - start[level] + 1
     * @param root
     * @param level
     * @param order
     * @param start
     * @param end
     * @return
     */
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

}