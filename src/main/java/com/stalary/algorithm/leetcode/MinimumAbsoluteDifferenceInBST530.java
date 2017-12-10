/**
 * @(#)MinimumAbsoluteDifferenceInBST530.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.TreeSet;

/**
 * MinimumAbsoluteDifferenceInBST530
 *
 * 求出两个节点最小的差值，二叉搜索树的特点：左子树小于根，右子树大于根，中序遍历为升序排序
 * @author lirongqian
 * @since 2017/12/4
 */
public class MinimumAbsoluteDifferenceInBST530 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(getMinimumDifference1(root));
    }

    /**
     * 可以通过TreeSet的查找比当前元素大的最小值和比当前元素小的最大值
     */
    static TreeSet<Integer> set = new TreeSet<>();
    static int min = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }

        set.add(root.val);

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }

    static Integer pre = null;
    public static int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference1(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        getMinimumDifference1(root.right);
        return min;
    }

}