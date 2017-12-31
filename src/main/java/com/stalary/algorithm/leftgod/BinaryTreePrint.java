package com.stalary.algorithm.leftgod;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/22
 */
public class BinaryTreePrint {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;
        printTree(treeNode1);
    }

    /**
     * 以层序的方式打印二叉树
     * **/
    public static int[][] printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();//队列
        ArrayList<TreeNode> level = new ArrayList<>();//存储一层
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        if(null == root) {
            throw new IllegalArgumentException();
        }
        TreeNode temp = root;//临时变量
        TreeNode last = root;//当前行的最右节点
        TreeNode nlast = null;//下一行的最右节点
        queue.add(root);
        while(!queue.isEmpty()) {
            temp = queue.poll();
            level.add(temp);
            if(temp.left != null) {
                queue.add(temp.left);
                nlast = temp.left;
            }
            if(temp.right != null) {
                queue.add(temp.right);
                nlast = temp.right;
            }
            // 当前层遍历完成
            if(last == temp) {
                last = nlast;
                result.add(level);
                level = new ArrayList<>();
            }
        }
        int[][] finalResult = new int[result.size()][];
        for(int i = 0; i < result.size(); i++) {
            finalResult[i] = new int[result.get(i).size()];
            for(int j = 0; j < finalResult[i].length; j++) {
                finalResult[i][j] = result.get(i).get(j).val;
                System.out.print(finalResult[i][j]);
            }
            System.out.println();
        }
        return finalResult;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
