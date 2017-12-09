/**
 * @(#)ReverseLinkedList.java, 2017-12-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import retrofit2.http.HEAD;

/**
 * ReverseLinkedList
 *
 * @author lirongqian
 * @since 2017/12/9
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = ReverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}