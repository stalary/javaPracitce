/**
 * @(#)PrintByZhi.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * PrintByZhi
 * <p>
 * 之字型打印二叉树
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class PrintByZhi {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new PrintByZhi().Print(root));
    }

    /**
     * 分别存储奇数层结点和偶数层结点
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        // 先将根结点放入s1中
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (!s1.empty() || !s2.empty()) {
            // 当层数为奇数层时
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        // 将子结点放入第二层中
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}