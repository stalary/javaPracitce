/**
 * @(#)NumberOfBoomerangs.java, 2017-12-08.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * NumberOfBoomerangs
 *
 * @author lirongqian
 * @since 2017/12/8
 */
public class NumberOfBoomerangs447 {

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0}, {1, 0}, {2, 0}
        };
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>(points.length);
        int sum = 0;
        // 每次统计一个点和其他点的距离，记录下来相同的点的数量，然后清空map
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dis = distance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer val : map.values()) {
                sum += val * (val - 1);
            }
            map.clear();
        }
        return sum;
    }

    public static int distance(int[] x, int[] y) {
        int dx = x[0] - y[0];
        int dy = x[1] - y[1];
        return dx*dx + dy*dy;
    }
}