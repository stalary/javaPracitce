package com.stalary.algorithm.netease; /**
 * @(#)Main2.java, 2018-08-11.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/08/11
 */
public class Main2 {


    /**
     * 苹果树
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, String> map = new HashMap<>();
        int temp = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = in.nextInt();
            int start = 0;
            int end = 0;
            start = temp;
            for (int j = 0; j < index; j++) {
                end = temp + j;
            }
            map.put(count++, start + ":" + end);
            temp = end + 1;
        }
        int ask = in.nextInt();
        for (int i = 0; i < ask; i++) {
            int t = in.nextInt();
            for (int j = 0; j < count; j++) {
                String s = map.get(j);
                String[] split = s.split(":");
                int a = Integer.valueOf(split[0]);
                int b = Integer.valueOf(split[1]);
                if (t >= a && t <= b) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}