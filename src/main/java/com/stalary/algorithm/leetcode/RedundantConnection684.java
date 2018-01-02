/**
 * @(#)RedundantConnection684.java, 2018-01-02.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * RedundantConnection684
 * <p>
 * 找到移除一个边，形成一个无环的树，如果有多个答案，则返回二维数组中最后出现的答案
 *
 * @author lirongqian
 * @since 02/01/2018
 */
public class RedundantConnection684 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        };
        System.out.println(new RedundantConnection684().findRedundantConnection(arr)[0] + "," + new RedundantConnection684().findRedundantConnection(arr)[1]);
    }

    /**
     * 可以使用并查集的思想
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) {
                return edge;
            } else {
                // 将父亲的值赋予儿子
                parent[find(parent, t)] = find(parent, f);
            }
        }
        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f == parent[f]) {
            return f;
        } else {
            parent[f] = find(parent, parent[f]);
            return parent[f];
        }
    }
}