/**
 * @(#)maxInWindows.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * maxInWindows
 * <p>
 * 获取每个窗口的最大值
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class maxInWindows {

    public static void main(String[] args) {
        int[] num = new int[]{
                2, 3, 4, 2, 6, 2, 5, 1
        };
        System.out.println(new maxInWindows().maxInWindows(num, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0) {
            return list;
        }
        if (size > num.length) {
            return list;
        }
        while (true) {
            int max = Integer.MIN_VALUE;
            for (int i = index; i < index + size; i++) {
                if (num[i] > max) {
                    max = num[i];
                }
            }
            list.add(max);
            index++;
            if (index + size > num.length) {
                break;
            }
        }
        return list;
    }

    /**
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     1.判断当前最大值是否过期
     2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        // 注意判空
        if (size == 0) {
            return res;
        }
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.add(i);
            } else if (begin > q.peekFirst()) {
                // 如果开始值已经大于最大值的下标，则移除最大值的下标
                q.pollFirst();
            }
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }
            q.add(i);
            // 当第一个窗口已全部填入值时，开始存入最大值
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}