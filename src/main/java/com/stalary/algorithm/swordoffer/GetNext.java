/**
 * @(#)GetNext.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * GetNext
 * <p>
 * 找到二叉树中序遍历中指定结点的下一个结点，结点中包含一个指向父结点的结点
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 当存在右子树时，找到右子树的最左结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 当不存在右子树时，则找第一个当前节点是父节点左孩子的节点
        while (pNode.next != null) {
            if(pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}