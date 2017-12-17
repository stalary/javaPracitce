/**
 * @(#)Clone.java, 2017-12-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * Clone
 * <p>
 * 将一个复杂的链表进行复制
 *
 * @author lirongqian
 * @since 2017/12/17
 */
public class Clone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 1.将每一个结点的复制的结点紧跟其后
     * 2.复制每个结点的指向
     * 3.拆分链表，偶数部分即为复制后的链表
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；A->A'->B->b'
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}