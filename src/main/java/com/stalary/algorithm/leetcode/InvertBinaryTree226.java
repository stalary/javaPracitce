
package com.stalary.algorithm.leetcode;

/**
 * InvertBinaryTree226
 *
 * 交换两颗二叉树
 *
 * Invert a binary tree.

        4
      /   \
     2     7
    / \   / \
   1   3 6   9
 to

        4
      /   \
     7     2
    / \   / \
   9   6 3   1
 * @author lirongqian
 * @since 2017/11/23
 */
public class InvertBinaryTree226 {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归的交换左右的结点
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

}