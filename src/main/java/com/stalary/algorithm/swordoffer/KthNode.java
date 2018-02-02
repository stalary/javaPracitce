/**
 * @(#)KthNode.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * KthNode
 *
 * 找出二叉搜索树的第n个结点
 * @author lirongqian
 * @since 2018/01/07
 */
public class KthNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(new KthNode().KthNode(root, 3).val);
    }

    int index = 0;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            // 找到二叉树最左的结点，即第一个结点
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            // 下标++，继续查找
            index++;
            if (index == k) {
                return pRoot;
            }
            // 查找右儿子
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }


}