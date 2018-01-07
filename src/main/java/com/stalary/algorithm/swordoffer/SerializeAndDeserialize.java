/**
 * @(#)SerializeAndDeserialize.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * SerializeAndDeserialize
 * <p>
 * 二叉树的序列化与反序列化
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class SerializeAndDeserialize {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        System.out.println(new SerializeAndDeserialize().Serialize(root));
    }


    public int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }

}