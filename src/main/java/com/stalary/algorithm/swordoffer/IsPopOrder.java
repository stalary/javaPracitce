/**
 * @(#)IsPopOrder.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.Stack;

/**
 * IsPopOrder
 *
 * 输入两个整数序列，第一个代表栈的压入顺序，第二个代表栈的弹出顺序。判断第二个序列是否符合要求
 * @author lirongqian
 * @since 2017/12/14
 */
public class IsPopOrder {

    public static void main(String[] args) {

    }

    /**
     * 使用一个辅助的栈，每次压入栈后判断栈顶元素是不是出栈顺序的第一个元素，若相等，则将出栈顺序后移一位
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        // 用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            // 如果栈不为空，并且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                // 出栈
                s.pop();
                // 出栈顺序后移
                popIndex++;
            }
        }
        // 如果最后栈为空，则证明出栈序列是正确的
        return s.empty();
    }
}