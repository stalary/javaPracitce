/**
 * @(#)LargeBST.java, 2018-09-11.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.interview;

/**
 * LargeBST
 * 求最大二叉搜索子树
 *
 * @author lirongqian
 * @since 2018/09/11
 */
public class LargeBST {

    public static void main(String[] args) {
        Node root = new Node(6);
        Node left = new Node(1);
        left.left = new Node(0);
        left.right = new Node(3);
        Node right = new Node(10);
        right.left = new Node(14);
        right.right = new Node(9);
        root.left = left;
        root.right = right;
        System.out.println(biggestSubBST(root));
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3];
        return posOrder(head, record);
    }

    /**
     * 使用后序遍历
     * @param head
     * @param record
     * @return
     */
    public static Node posOrder(Node head, int[] record) {
        if (head == null) {
            // 节点数
            record[0] = 0;
            // 最小值
            record[1] = Integer.MAX_VALUE;
            // 最大值
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        // 找到左侧的搜索树
        Node lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        // 找到右侧的搜索树
        Node rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        // 求出最小值
        record[1] = Math.min(lMin, value);
        // 求出最大值
        record[2] = Math.max(rMax, value);

        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            // 当为搜索树时，存储总节点数
            record[0] = lSize + rSize + 1;
            return head;
        }
        // 计算最大节点数量
        record[0] = Math.max(lSize, rSize);
        // 返回节点较多的子树
        return lSize > rSize ? lBST : rBST;
    }

}