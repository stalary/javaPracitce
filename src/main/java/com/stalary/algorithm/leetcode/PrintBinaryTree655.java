/**
 * @(#)PrintBinaryTree655.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * PrintBinaryTree655
 *
 * 打印出一个二叉树，行数是高度，列数是一层所能容纳的最大的结点数
 * @author lirongqian
 * @since 27/12/2017
 */
public class PrintBinaryTree655 {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int height = calHigh(root);
        int rows = height;
        int columns = (int) Math.pow(2, height) - 1;
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>(row));
        }
        // 下标从0开始，所以末尾-1
        help(root, res, 0, rows, 0, columns - 1);
        return res;
    }

    public void help(TreeNode root, List<List<String>> res, int row, int total, int i, int j) {
        if (row == total || root == null) {
            return;
        }
        // 将结点存入中点
        int mid = (i + j) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        help(root.left, res, row + 1, total, i, mid - 1);
        help(root.right, res, row + 1, total, mid + 1, j);
    }

    public int calHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calHigh(root.left), calHigh(root.right));
    }
}