package com.stalary.algorithm.interview; /**
 * Example:
 * 10
 * /    \
 * 1      11
 * \       \
 * 6       12
 * <p>
 * out: [1, 6, 10, 11, 12]
 */

import lombok.Data;

import java.util.Stack;

/**
 * 额外空间复杂度是 O(h)，其中 h 是这棵树的高度
 * 设计实现一个带有下列属性的二叉查找树的迭代器
 * 左节点值比父节点值小，右节点值比父节点值大
 * 元素按照递增的顺序被访问（比如中序遍历）
 * next()和hasNext()的询问操作要求均摊时间复杂度是 O(1)
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    /**
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        stack.push(root);
    }

    /**
     * 下一个节点的情况：
     * 1. 右子节点，需要继续查找右子树的最左节点
     * 2. 左子节点的根节点
     * 3. 第一个左节点为当前元素的根节点
     * @return
     */
    /**
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return stack.peek() != null || stack.size() != 1;
        }
        return false;
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            // 找最左节点
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            // 当最后一个元素时，会存在将空值存入的情况
            tempNode = stack.pop();
            stack.push(tempNode.right);
            return tempNode;
        }
        return null;
    }

    @Data
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10),
                n1 = new TreeNode(1),
                n11 = new TreeNode(11),
                n6 = new TreeNode(6),
                n12 = new TreeNode(12);
        root.left = n1;
        root.right = n11;
        n1.right = n6;
        n11.right = n12;
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            System.out.print(node.val + " "); //out: 1 6 10 11 12
        }
    }
}