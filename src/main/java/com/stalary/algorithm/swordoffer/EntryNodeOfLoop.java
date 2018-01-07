/**
 * @(#)EntryNodeOfLoop.java, 2017-12-09.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * EntryNodeOfLoop
 *
 * 一个链表中包含环，找出该链表的环的入口 w
 * @author lirongqian
 * @since 2017/12/9
 */
public class EntryNodeOfLoop {

    /**
     * 使用一对快慢指针来判断是否有环，快指针每次移动2，慢指针每次移动1
     * @param pHead
     * @return
     */
    public ListNode meetNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != slow) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 从相遇点向后移动，当再次回到这个点的时候，就能统计出环中元素的数量
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = meetNode(pHead);
        if (meetNode == null) {
            return null;
        }
        int count = 1;
        ListNode p1 = meetNode;
        while (p1.next != meetNode) {
            p1 = p1.next;
            count++;
        }
        p1 = pHead;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        ListNode p2 = pHead;
        while (p2 != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}