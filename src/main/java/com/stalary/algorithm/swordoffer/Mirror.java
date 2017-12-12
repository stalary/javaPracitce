/**
 * @(#)Mirror.java, 2017-12-12.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * Mirror
 *
 * @author lirongqian
 * @since 2017/12/12
 */
public class Mirror {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);
        Mirror mirror = new Mirror();
        mirror.Mirror(node);
        mirror.printTree(node);
    }

    public void printTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}