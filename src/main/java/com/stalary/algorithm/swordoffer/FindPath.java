/**
 * @(#)FindPath.java, 2017-12-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * FindPath
 * <p>
 * 打印出二叉树中路径为目标值的路径
 *
 * @author lirongqian
 * @since 2017/12/17
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(new FindPath().FindPath(root, 22));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        // 判断是否已经到达叶结点
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 回退到上一个结点
        list.remove(list.size() - 1);
        return listAll;

    }
}