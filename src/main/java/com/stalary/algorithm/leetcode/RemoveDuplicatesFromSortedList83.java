/**
 * @(#)RemoveDuplicatesFromSortedList83.java, 2017-12-19.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * RemoveDuplicatesFromSortedList83
 * <p>
 * 给定一个有序的链表，删除所有重复，使每个元素只出现一次
 *
 * @author lirongqian
 * @since 19/12/2017
 */
public class RemoveDuplicatesFromSortedList83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode node = new RemoveDuplicatesFromSortedList83().deleteDuplicates(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        // 判断是否重复，如果重复则向后移动一个元素
        return head.val == head.next.val ? head.next : head;
    }
}