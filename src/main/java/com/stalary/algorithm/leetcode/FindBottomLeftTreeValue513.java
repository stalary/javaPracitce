/**
 * @(#)FindBottomLeftTreeValue513.java, 2017-12-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * FindBottomLeftTreeValue513
 *
 * 找到二叉树最左边底部元素
 * @author lirongqian
 * @since 25/12/2017
 */
public class FindBottomLeftTreeValue513 {

    public static void main(String[] args) {

    }

    int ans = 0, h = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        /**
         * 当仍然存在子结点时，继续递归遍历
         */
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }
}