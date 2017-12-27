/**
 * @(#)MostFrequentSubtreeSum508.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * MostFrequentSubtreeSum508
 *
 * 找出出现频率最大的子树
 * @author lirongqian
 * @since 27/12/2017
 */
public class MostFrequentSubtreeSum508 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(14);
        node.left.left = new TreeNode(1);
        System.out.println(Arrays.toString(new MostFrequentSubtreeSum508().findFrequentTreeSum(node)));
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        help(root, map);
        int max = Integer.MIN_VALUE;
        for (int out : map.values()) {
            if (out > max) {
                max = out;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int in : map.keySet()) {
            if (map.get(in) == max) {
                list.add(in);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int help(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left, map);
        int right = help(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0 ) + 1);
        return sum;
    }
}