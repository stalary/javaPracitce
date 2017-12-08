/**
 * @(#)ImageSmoother661.java, 2017-12-08.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ImageSmoother661
 *
 * 给定一个矩阵，将每一个元素周围八个元素以及自己下取整再赋值给自己，若在边界则不取
 * @author lirongqian
 * @since 2017/12/8
 */
public class ImageSmoother661 {

    public static void main(String[] args) {

    }

    /**
     * 可以使用一个-1，0，1的数组来表示动作
     * @param M
     * @return
     */
    public static int[][] imageSmoother(int[][] M) {
        if (M == null) {
            return null;
        }
        int rows = M.length;
        if (rows == 0) {
            return new int[0][];
        }

        int cols = M[0].length;

        int result[][] = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }

    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}