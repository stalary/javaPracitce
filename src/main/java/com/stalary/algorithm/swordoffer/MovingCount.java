/**
 * @(#)movingCount.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * movingCount
 * <p>
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子
 * 求该机器人能够达到多少个格子
 *
 * @author lirongqian
 * @since 2018/01/07
 */
public class MovingCount {


    public int movingCount(int threshold, int rows, int cols) {
        //记录是否已经走过
        boolean[][]  flag= new boolean[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        // 判断边界，判断每一位和是否大于限定值，判断是否已经走过
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j]) {
            return 0;
        }
        flag[i][j] = true;
        // 四个方向移动
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        while (i > 10) {
            sum += i % 10;
            i = i / 10;
        }
        sum += i;
        return sum;
    }
}