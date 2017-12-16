/**
 * @(#)PrintFromTopToBottom.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.*;

/**
 * PrintFromTopToBottom
 *
 * 从上往下遍历二叉树，同层节点从左至右打印
 * @author lirongqian
 * @since 2017/12/14
 */
public class PrintFromTopToBottom {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        PrintFromTopToBottom p = new PrintFromTopToBottom();
        System.out.println(p.PrintFromTopToBottom(root));
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 存入头结点
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 拿出头结点
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}