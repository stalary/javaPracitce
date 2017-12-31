/**
 * @(#)FindModeInBinarySearchTree501.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * FindModeInBinarySearchTree501
 *
 * 查找二叉搜索树中出现次数最多的结点
 * @author lirongqian
 * @since 31/12/2017
 */
public class FindModeInBinarySearchTree501 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(new FindModeInBinarySearchTree501().findMode1(root)));
    }

    private Integer prev = null;
    private int count = 1;
    private int max = 0;

    /**
     * 按中序遍历二叉搜索树，即为顺序遍历，如果值相同，count++，不相同，替换count，最后更新max，添加val
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }

    /**
     * 使用map来存储出现的次数，最后找到次数最多的
     */
    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        help1(root);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int out : map.values()) {
            if (out > max) {
                max = out;
            }
        }
        for (int out : map.keySet()) {
            if (map.get(out) == max) {
                list.add(out);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public void help1(TreeNode root) {
        if (root == null) {
            return;
        }
        help1(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        help1(root.right);
    }
}