/**
 * @(#)BinarySearchTreeIterator173.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Stack;

/**
 * BinarySearchTreeIterator173
 * <p>
 * 构造一颗二叉搜索树
 *
 * @author lirongqian
 * @since 31/12/2017
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        add(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // 拿出下一个结点的值，并存入后续结点
        TreeNode node = stack.pop();
        TreeNode cur = node;
        // traversal right branch
        cur = cur.right;
        add(cur);
        return node.val;
    }

    private void add(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (node.left != null) {
                node = node.left;
            } else {
                break;
            }
        }
    }
}