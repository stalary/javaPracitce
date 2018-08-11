/**
 * @(#)Main3.java, 2018-08-11.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.toutiao;

import java.util.Scanner;

/**
 * Main3
 *
 * @author lirongqian
 * @since 2018/08/11
 */
public class Main3 {

    /**
     * 字母交换
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = in.nextInt();
        char[] chars = str.toCharArray();
        // 首先求出相邻重复元素的最大值
        int max = Integer.MIN_VALUE;
        int count = 1;
        char out = 'a';
        // 统计最大重复的开始位置
        int start = 0;
        // 统计最大重复的结束位置
        int end = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
                out = chars[i];
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
                start = i - count;
                end = i + 1;
            }
        }
        boolean flag = true;
        int memory = n;
        // 当未找到或者n不足时不再循环
        while (flag && n > 0) {
            int last = start - n > 0 ? start - n : 0;
            // 向前查找
            for (int i = start; i >= last; i--) {
                n--;
                if (chars[i] == out) {
                    count++;
                    flag = true;
                    // 查找到了，n要减少
                    memory = n;
                    start = i;
                    break;
                }
                if (i == last) {
                    // 代表未找到
                    flag = false;
                    n = memory;
                }
            }
            int right = end + n < chars.length ? end + n : chars.length - 1;
            // 向后查找
            for (int i = end + 1; i < right; i++) {
                n--;
                if (chars[i] == out) {
                    max++;
                    flag = true;
                    memory = n;
                    end = i;
                    break;
                }
                if (i == right - 1) {
                    flag = false;
                    n = memory;
                }
            }
        }
        System.out.println(max);
    }
}