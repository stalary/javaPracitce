/**
 * @(#)Second.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.yixin;

import java.util.Scanner;

/**
 * Second
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class Second {

    public static int kmp(String source, String target, int[] next) {
        for (int i = 0, j = 0; i < source.length(); i++) {
            // 不相等时，取next数组
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            // 相等时后移
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            // 匹配完成，返回匹配的起始位置
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] next(String target) {
        int[] next = new int[target.length()];
        // 初始值为0
        next[0] = 0;
        for (int i = 1, j = 0; i < target.length(); i++) {
            // 向后扩展，元素不重复时可直接使用之前的next
            while (j > 0 && target.charAt(j) != target.charAt(i)) {
                j = next[j - 1];
            }
            // 存在前后相等时++
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String source = "babaababc";
        String target = "ababc";
        int[] next = next(target);
        int res = kmp(source, target, next);
        System.out.println(res);

    }
}