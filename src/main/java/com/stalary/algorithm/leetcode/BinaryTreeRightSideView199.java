/**
 * @(#)BinaryTreeRightSideView199.java, 2018-01-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTreeRightSideView199
 *
 * 输出在右边可以直接接触到的结点
 * @author lirongqian
 * @since 01/01/2018
 */
public class BinaryTreeRightSideView199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new BinaryTreeRightSideView199().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    /**
     * 通过判断该层是否已经存在结点，就可以拿到最外边界的结点
     * @param curr
     * @param result
     * @param currDepth
     */
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}