/**
 * @(#)Main1.java, 2018-08-11.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.toutiao2018;

import java.util.*;

/**
 * com.stalary.algorithm.toutiao2019.Main1
 *
 * @author lirongqian
 * @since 2018/08/11
 */
public class Main1 {

    /**
     * 用户喜好
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int input = in.nextInt();
            List<Integer> mapList = map.getOrDefault(input, new ArrayList<>());
            mapList.add(i);
            map.put(input, mapList);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int lo = in.nextInt();
            int hi = in.nextInt();
            int des = in.nextInt();
            List<Integer> list = map.get(des);
            int count = 0;
            if (list != null) {
                for (Integer integer : list) {
                    if (integer >= lo && integer <= hi) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}