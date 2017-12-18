/**
 * @(#)HasSubtree.java, 2017-12-11.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;


/**
 * HasSubtree
 *
 * @author lirongqian
 * @since 2017/12/11
 */
public class HasSubtree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);

    }

    /**
     *  首先找到子树的根，然后判断后续结点是否相同
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean flag = false;
        // 先找到相同的点作为根
        if (root1.val == root2.val) {
            // 判断以这个根为起点是否有为子树
            flag = doesTree1HaveTree2(root1, root2);
        }
        // 如果找不到，就再去根节点的左儿子继续查找
        if (!flag) {
            flag = HasSubtree(root1.left, root2);
        }
        // 如果找不到，就再去根节点的右儿子继续查找
        if (!flag) {
            flag = HasSubtree(root1.right, root2);
        }
        return flag;
    }

    /**
     * 直接判断子树是否存在，通过递归查找左右子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }
        if (doesTree1HaveTree2(root1, root2)) {
            return true;
        }
        // 递归的查找左子树和右子树
        return doesTree1HaveTree2(root1.left, root2) || doesTree1HaveTree2(root1.right, root2);
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

}