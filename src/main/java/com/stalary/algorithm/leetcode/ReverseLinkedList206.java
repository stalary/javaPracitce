/**
 * @(#)ReverseLinkedList206.java, 2017-12-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ReverseLinkedList206
 *
 * 反转list
 * @author lirongqian
 * @since 2017/12/7
 */
public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);
        listNode = reverseList(listNode);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }

    /**
     * 递归方法逆置需要实现head节点的下一个结点所指向的下一个节点为head，并且head的下一个节点要为空，否则形成环。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        // head -> head.next -> head
        head.next.next = head;
        // newHead -> head -> null
        head.next = null;
        return p;
    }

    /**
     * 迭代的方法实现逆置，当前节点的下一个节点指向上一个节点，必须事先存储前一个节点，防止丢失
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}