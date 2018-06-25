/**
 * @(#)LCS.java, 2018-06-23.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * LCS
 * 最长公共子序列
 * @author lirongqian
 * @since 2018/06/23
 */
public class LCS {

    public static void main(String[] args) {
        String str1 = "fjssharpsword";
        String str2 = "helloworld";
        //计算lcs递归矩阵
        int[][] re = longestCommonSubsequence(str1, str2);
        //打印矩阵
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                System.out.print(re[i][j] + "   ");
            }
            System.out.println();
        }
        //输出LCS
        print(re, str1, str2, str1.length(), str2.length());
    }

    public static int[][] longestCommonSubsequence(String str1, String str2) {
        // 建立二维矩阵
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        // 填充矩阵
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                // 当字符串当前元素相同时，数量加1
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    // 不相同时，求上方和左侧的最大值
                    matrix[i][j] = Math.max(matrix[i - 1][j] , matrix[i][j - 1]);
                }
            }
        }
        return matrix;
    }

    //根据矩阵输出LCS
    public static void print(int[][] opt, String x, String y, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        // 相等时直接输出
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
            print(opt, x, y, i - 1, j - 1);
            System.out.print(x.charAt(i - 1));
            // 否则查找上方和左侧较大的值进行输出
        } else if (opt[i - 1][j] >= opt[i][j]) {
            print(opt, x, y, i - 1, j);
        } else {
            print(opt, x, y, i, j - 1);
        }
    }
}