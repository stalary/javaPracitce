
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * AverageofLevelsInBinaryTree637
 * <p>
 * 求二叉树每一层的平均值
 *
 * @author lirongqian
 * @since 2017/11/22
 */
public class AverageofLevelsInBinaryTree637 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<Double> list = new AverageofLevelsInBinaryTree637().averageOfLevels1(treeNode);
        for (double out : list) {
            System.out.print(out + " ");
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return list;
        }
        q.add(root);
        while (!q.isEmpty()) {
            // 第一次q只有root一个元素
            int n = q.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                // 拿出根结点
                TreeNode node = q.poll();
                sum += node.val;
                // 此时加入非空的左儿子和右儿子，n的数量随之增长
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(sum / n);
        }
        return list;
    }

    /**
     * 按层进行求平均值
     *
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        // 计算每层的值
        List<Double> answer = new ArrayList<>();

        // 计算每层的结点数
        List<Integer> counter = new ArrayList<>();

        dfs(0, root, answer, counter);

        // 将answer除以总数
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }

        // 扩展答案链表
        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }

        answer.set(level, answer.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);

        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}