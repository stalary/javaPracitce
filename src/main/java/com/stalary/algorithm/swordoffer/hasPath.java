/**
 * @(#)hasPath.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * hasPath
 *
 * 在矩阵中找到路径，已经经过的点不能再次经过
 * @author lirongqian
 * @since 2018/01/07
 */
public class hasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归
     * @param matrix
     * @param rows
     * @param cols
     * @param i
     * @param j
     * @param str
     * @param k
     * @param flag
     * @return
     */
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag) {
        // 将矩阵下标转化为一维的坐标，当前行*总列数+当前列
        int index = i * cols + j;
        // 判断边界，判断当前坐标是否为所需坐标，判断当前坐标是否已经使用
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        // k为已经走过的长度
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        // 判断四个方向是否有可达的点
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        // 如果没有找到符合的下个坐标，则返回原坐标
        flag[index] = false;
        return false;
    }
}