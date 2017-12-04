/**
 * @(#)DoubleStackImplementsQueue.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.Stack;

/**
 * DoubleStackImplementsQueue
 *
 * 用双栈实现队列
 * @author lirongqian
 * @since 2017/12/4
 */
public class DoubleStackImplementsQueue {

    static Stack<Integer>  stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer data = stack1.pop();
                stack2.push(data);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        pop();
        System.out.println(stack1);
        System.out.println(stack2);
    }


}