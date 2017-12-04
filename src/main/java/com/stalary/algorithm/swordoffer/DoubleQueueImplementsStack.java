/**
 * @(#)DoubleQueueImplementsStack.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DoubleQueueImplementsStack
 *
 * @author lirongqian
 * @since 2017/12/4
 */
public class DoubleQueueImplementsStack {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    public static void push(Integer node) {
        queue1.add(node);
    }

    public static int pop() {
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        } else {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        pop();
        System.out.println(queue2);
        pop();
        System.out.println(queue1);
    }
}