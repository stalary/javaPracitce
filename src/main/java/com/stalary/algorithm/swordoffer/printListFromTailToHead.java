/**
 * @(#)printListFromTailToHead.java, 2017-11-29.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * printListFromTailToHead
 * <p>
 * 倒着打印出链表
 *
 * @author lirongqian
 * @since 2017/11/29
 */
public class printListFromTailToHead {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(5);
        for (int out : printListFromTailToHead(l1)) {
            System.out.println(out + " ");
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}