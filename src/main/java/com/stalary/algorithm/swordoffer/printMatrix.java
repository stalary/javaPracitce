/**
 * @(#)printMatrix.java, 2017-12-12.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * printMatrix
 * <p>
 * 将矩阵按从外到里的顺序打印出来
 *
 * @author lirongqian
 * @since 2017/12/12
 */
public class printMatrix {

    public static void main(String[] args) {

    }

    /**
     * 实际就是按层打印，所以需要先计算出层数
     * 然后要找出来四个角
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return result;
        }
        //层数
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) {
                //左至右
                result.add(matrix[i][k]);
            }
            for (int j = i + 1; j < n - i; j++) {
                //右上至右下
                result.add(matrix[j][m - i - 1]);
            }
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                //右至左
                result.add(matrix[n - i - 1][k]);
            }
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) {
                //左下至左上
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

}