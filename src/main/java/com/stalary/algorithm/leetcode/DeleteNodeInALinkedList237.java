/**
 * @(#)DeleteNodeInALinkedList237.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.LinkedList;

/**
 * DeleteNodeInALinkedList237
 *
 * @author lirongqian
 * @since 2017/12/4
 */
public class DeleteNodeInALinkedList237 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        deleteNode(node.next.next);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}