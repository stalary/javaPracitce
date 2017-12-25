/**
 * @(#)FindFirstCommonNode.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * FindFirstCommonNode
 *
 * @author lirongqian
 * @since 24/12/2017
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {

    }

    /**
     * 找出两个链表的长度，然后让长的部分走两个链表的差，然后再一起走，两个结点肯定拥有公共结点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int p1 = len(pHead1);
        int p2 = len(pHead2);
        /**
         * 较长的结点走两个结点差的长度
         */
        if (p1 > p2) {
            pHead1 = walk(pHead1, p1 - p2);
        } else {
            pHead2 = walk(pHead2, p2 - p1);
        }
        /**
         * 移动结点，当两个结点相同时输出
         */
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public int len(ListNode head) {
        if (head == null) {
            return 0;
        }
        int sum = 1;
        while (head.next != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }

    public ListNode walk(ListNode node, int step) {
        while (step > 0) {
            node = node.next;
            step--;
        }
        return node;
    }
}