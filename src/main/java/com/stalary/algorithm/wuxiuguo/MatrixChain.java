/**
 * @(#)MatrixChain.java, 2018-06-23.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * MatrixChain
 *
 * @author lirongqian
 * @since 2018/06/23
 */
public class MatrixChain {
    static int m[][], s[][];

    /**
     * p[]记录矩阵A1，A2，A3，....,An;m[][]记录每次计算之后的最少次数及最优值;s[][]记录最佳断点位置。
     */
    public static void matrixChain(int p[], int m[][], int s[][]) {
        // 矩阵数量
        int n = p.length - 1;
        //
        int i, j;
        // 矩阵链的长度
        for (int r = 2; r <= n; r++) {
            // 矩阵链长度为r的矩阵的起始位置，去除掉边界值
            for (i = 1; i <= n - r + 1; i++) {
                // 矩阵链长度为r，起始位置为i的最后一个矩阵的位置，去除点掉边界
                j = i + r - 1;
                // 计算连乘初始值
                m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
                // 括号初始位置
                s[i][j] = i;
                // 探测最优点，k为分割点
                for (int k = i + 1; k < j; k++) {
                    // 计算连乘值
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    // 当连乘值小时
                    if (t < m[i][j]) {
                        // 存储最小值
                        m[i][j] = t;
                        // 存储括号位置
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void traceBack(int s[][], int i, int j) {
        if (i == j) {
            return;
        }
        traceBack(s, i, s[i][j]);
        traceBack(s, s[i][j] + 1, j);
        System.out.println("Multiply    A" + i + "," + s[i][j] + "and A"
                + (s[i][j] + 1) + "," + j);
    }

    public static void main(String[] args) {
        int p[] = {30, 35, 15, 5, 10, 20};
        int n = p.length - 1;
        m = new int[p.length][p.length];
        s = new int[p.length][p.length];
        matrixChain(p, m, s);
        traceBack(s, 1, n);
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%6d", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.printf("%6d", s[i][j]);
            }
            System.out.println();
        }
    }
}