package com.stalary.algorithm.toutiao2019; /**
 * @(#)Main1.java, 2018-08-12.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.Scanner;

/**
 * com.stalary.algorithm.toutiao2019.Main1
 *
 * @author lirongqian
 * @since 2018/08/12
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        int n = Integer.valueOf(split[0]);
        int m = Integer.valueOf(split[1]);
        int[][] rect = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.next();
            String[] split1 = line.split(",");
            for (int j = 0; j < n; j++) {
                rect[i][j] = Integer.valueOf(split1[j]);
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = dfs(rect, i, j, m, n);
                if (temp != 0) {
                    count++;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        System.out.println(count + "," + max);
    }

    public static int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 +
                    dfs(grid, i - 1, j, m, n)
                    + dfs(grid, i, j + 1, m, n)
                    + dfs(grid,i + 1, j, m, n)
                    + dfs(grid, i, j - 1, m, n)
                    + dfs(grid, i - 1, j - 1, m, n)
                    + dfs(grid, i + 1, j + 1, m, n)
                    + dfs(grid, i + 1, j - 1, m, n)
                    + dfs(grid, i - 1, j + 1, m, n);
        }
        return 0;

    }

}