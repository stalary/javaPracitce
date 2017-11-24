/**
 * @(#)ReshapeTheMatrix566.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * ReshapeTheMatrix566
 * <p>
 * 矩阵转化，hint：当行列相乘相等时才能进行转化
 *
 * @author lirongqian
 * @since 2017/11/21
 */
public class ReshapeTheMatrix566 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1}, {2}, {3}, {4}
        };
        int[][] temp = matrixReshape(nums, 2, 4);
        for (int[] te : temp) {
            for (int out : te) {
                System.out.print(out + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (n * m != r * c) {
            return nums;
        }
        int[][] temp = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            temp[i / c][i % c] = nums[i / m][i % m];
        }
        return temp;
    }

}