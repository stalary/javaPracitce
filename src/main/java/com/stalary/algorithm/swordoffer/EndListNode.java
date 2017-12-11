/**
 * @(#)EndListNode.java, 2017-12-08.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import javax.xml.soap.Node;
import java.util.ArrayList;

/**
 * EndListNode
 *
 * @author lirongqian
 * @since 2017/12/8
 */
public class EndListNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(FindKthToTail(node, 2).val);
    }

    /**
     * 快慢指针
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点。
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (head.next != null) {
                head = head.next;
            } else {
                return null;
            }
        }
        while (head.next != null) {
            head = head.next;
            last = last.next;
        }
        return last;

    }

}

