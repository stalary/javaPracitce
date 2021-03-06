
package com.stalary.algorithm.leetcode;

import java.util.Stack;

/**
 * KthSmallestElementInABST230
 *
 * 在二叉搜索树中查找第k小的元素
 * @author lirongqian
 * @since 31/12/2017
 */
public class KthSmallestElementInABST230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(new KthSmallestElementInABST230().kthSmallest(root, 2));
    }

    /**
     * 中序遍历二叉树，去查找元素
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int count = 0;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            count++;
            if (count == k) {
                return temp.val;
            }
            temp = temp.right;
        }
        return -1;
    }

    /**
     * 首先去搜索左子树，如果超过范围，则将范围减去左子树的结点树，再去搜索右子树
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        // 因为是从下一个结点开始计算，所以使用时count要+1
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 1 is counted as current node
            return kthSmallest(root.right, k-1-count);
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}