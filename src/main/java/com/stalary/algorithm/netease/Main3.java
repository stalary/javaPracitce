package com.stalary.algorithm.netease; /**
 * @(#)Main3.java, 2018-08-11.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main3
 *
 * @author lirongqian
 * @since 2018/08/11
 */
public class Main3 {

    /**
     * 字典排序的第几个
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        for (int i = 0; i < m; i++) {
            sb.append('z');
        }
        permutation(sb.toString(), k);
    }

    public static void permutation(String str, int k) {
        ArrayList<String> list = new ArrayList<>();
        help(str.toCharArray(), 0, list);
        // 最后按字典顺序排序
        Collections.sort(list);
        System.out.println(list.get(k - 1));
    }

    public static void help(char[] chars, int i, ArrayList<String> list) {
        // 判断是最后一层时再输入数组
        if (i == chars.length - 1) {
            String str = String.valueOf(chars);
            // 防止重复输入
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                // 交换两个元素
                swap(chars, i, j);
                // 添加入list
                help(chars, i + 1, list);
                // 元素归位
                swap(chars, i, j);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}