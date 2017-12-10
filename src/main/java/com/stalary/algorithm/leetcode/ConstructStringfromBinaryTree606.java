/**
 * @(#)ConstructStringfromBinaryTree606.java, 2017-11-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ConstructStringfromBinaryTree606
 *
 * 将二叉树前序打印，关键在于判断左右儿子是否为空，左儿子为空时需要打印()
 * @author lirongqian
 * @since 2017/11/26
 */
public class ConstructStringfromBinaryTree606 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = "" + t.val;
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if ("".equals(left) && "".equals(right)) {
            return result;
        }
        if ("".equals(left)) {
            return result + "()" + "(" + right + ")";
        }
        if ("".equals(right)) {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }

}