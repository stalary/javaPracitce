/**
 * @(#)BinaryTree.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.other;

/**
 * BinaryTree
 *
 * @author lirongqian
 * @since 31/12/2017
 */

import com.stalary.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private int val;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
    }

    /**
     * 递归实现前序遍历
     */
    protected static void preorder(BinaryTree p) {
        if (p != null) {
            System.out.println(p.val);
            preorder(p.left);
            preorder(p.right);
        }
    }

    /**
     * 递归实现中序遍历
     */
    protected static void inorder(BinaryTree p) {
        if (p != null) {
            inorder(p.left);
            System.out.println(p.val);
            inorder(p.right);
        }
    }

    /**
     * 递归实现后序遍历
     */
    protected static void postorder(BinaryTree p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.val);
        }
    }
    /**********************************************************************************************/
    /**
     * 非递归实现前序遍历
     */
    protected static void iterativePreorder(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.empty()) {
                root = stack.pop();
                System.out.println(root.val);
                // 因为栈是后进先出，所以先入栈右结点
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left!= null) {
                    stack.push(root.left);
                }
            }
        }
    }

    /**
     * 非递归实现前序遍历2
     */
    protected static void iterativePreorder2(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree temp = root;
        while (temp != null || stack.size() > 0) {
            while (temp != null) {
                //压入所有的左节点，压入前访问它。左节点压入完后pop访问右节点。像这样算法时思考规律性的东西在哪。不管哪个节点都要压所节点判断右节点。
                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            // 取出结点时，顺便拿到右儿子
            if (stack.size() > 0) {
                temp = stack.pop();
                temp = temp.right;
            }
        }
    }

    /**
     * 非递归实现中序遍历
     * 思路与上面iterativePreorder 一致。
     */
    protected static void iterativeInorder(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        while (root != null) {
            while (root != null) {
                // 当前节点右子入栈
                if (root.right != null) {
                    stack.push(root.right);
                }
                // 当前节点入栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            while (!stack.empty() && root.right == null) {
                System.out.println(root.val);
                root = stack.pop();
            }
            System.out.println(root.val);
            if (!stack.empty()) {
                root = stack.pop();
            } else {
                root = null;
            }
        }
    }

    /**
     * 非递归实现中序遍历2
     */
    protected static void iterativeInorder2(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree temp = root;
        while (temp != null || stack.size() > 0) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (stack.size() > 0) {
                temp = stack.pop();
                //与iterativePreorder2比较只有这句话的位置不一样，弹出时再访问。
                System.out.println(temp.val);
                temp = temp.right;
            }
        }
    }

    /**
     * 非递归实现后序遍历
     */
    protected static void iterativePostorder(BinaryTree root) {
        BinaryTree temp = root;
        Stack<BinaryTree> stack = new Stack<>();
        while (root != null) {
            // 左子树和根入栈
            for (; root.left != null; root = root.left) {
                stack.push(root);
            }

            /**
             *      1
             *    2   3
             *   4     5
             *    6
             */
            // 当前结点不为空，右结点为空或者右结点已经打印时，打印当前结点
            // 即第一次循环打印完6以后，打印4的过程
            while (root != null && (root.right == null || root.right == temp)) {
                System.out.println(root.val);
                //
                temp = root;
                // 遍历完成
                if (stack.empty()) {
                    return;
                }
                root = stack.pop();
            }
            // 将最后一个左结点入栈，并继续遍历右结点
            if (root != null) {
                stack.push(root);
                root = root.right;
            }
        }
    }

    /**
     * 非递归实现后序遍历 双栈法
      */
    protected static void iterativePostorder2(BinaryTree root) {
        //理解左子树   右子树 根递归性质，把它运用到循环当中去。
        //左子树栈
        Stack<BinaryTree> lstack = new Stack<>();
        //右子树栈
        Stack<BinaryTree> rstack = new Stack<>();
        BinaryTree temp = root, right;
        do {
            while (temp != null) {
                right = temp.right;
                lstack.push(temp);
                rstack.push(right);
                temp = temp.left;
            }
            temp = lstack.pop();
            right = rstack.pop();
            if (right == null) {
                System.out.println(temp.val);
            } else {
                lstack.push(temp);
                rstack.push(null);
            }
            temp = right;
        } while (lstack.size() > 0 || rstack.size() > 0);
    }

    /**
     * 非递归后续遍历 单栈
     */
    public static void postorderTraversal(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node = root, prev = root;
        while (node != null || stack.size() > 0) {
            // 先放入最左的儿子的父结点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 有根结点才可以放入后续结点
            if (stack.size() > 0) {
                // 当没有右儿子或者右儿子等于根时，将结点的值放入list
                BinaryTree temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    node = stack.pop();
                    System.out.println(node.val);
                    prev = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

    /**
     * 非递归实现后序遍历4 双栈法
     **/
    protected static void iterativePostorder4(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> temp = new Stack<>();
        BinaryTree binaryTree = root;
        while (binaryTree != null || stack.size() > 0) {
            while (binaryTree != null) {
                temp.push(binaryTree);
                stack.push(binaryTree);
                binaryTree = binaryTree.right;
            }
            if (stack.size() > 0) {
                binaryTree = stack.pop();
                binaryTree = binaryTree.left;
            }
        }
        while (temp.size() > 0) {//把插入序列都插入到了temp。
            binaryTree = temp.pop();
            System.out.println(binaryTree.val);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.left.right = new BinaryTree(6);
        tree.right = new BinaryTree(3);
        tree.right.right = new BinaryTree(5);
        BinaryTree.postorderTraversal(tree);
    }

}
