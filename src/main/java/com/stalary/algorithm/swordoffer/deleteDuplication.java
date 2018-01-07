/**
 * @(#)deleteDuplication.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * deleteDuplication
 *
 * 删除链表中重复的结点
 * @author lirongqian
 * @since 2018/01/07
 */
public class deleteDuplication {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(4);
        ListNode pHead = new deleteDuplication().deleteDuplication(node);
        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 当下一个结点和当前值相同时
        if (pHead.next.val == pHead.val) {
            ListNode pNode = pHead.next;
            // 跳过所有与当前结点的值相同的
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            // 继续遍历后续的结点
            return deleteDuplication(pNode);
        } else {
            // 当不相同时，遍历下一个结点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

}