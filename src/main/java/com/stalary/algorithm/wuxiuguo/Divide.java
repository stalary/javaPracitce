/**
 * @(#)Divide.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * Divide
 *
 * @author lirongqian
 * @since 2018/06/20
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(7));
    }

    public static int divide(int n) {
        // 一半的和
        int sum = (n * (n + 1)) / 4;
        int[][] f = new int[n + 1][sum + 1];
        if ((n * (n + 1)) % 4 != 0) {
            return 0;
        }
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= sum; k++) {
                if (i > k) {
                    f[i][k] = f[i - 1][k];
                } else {
                    f[i][k] = f[i - 1][k] + f[i - 1][k - i];
                }
            }
        }
        return f[n][sum] /2;
    }

    public static int divide1(int n) {
        // 一半的和
        int sum = n * (n + 1) / 4;
        int[] f = new int[sum + 1];
        if (n * (n + 1) % 4 != 0) {
            return 0;
        }
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = sum; k >= i; k--) {
                f[k] += f[k - i];
            }
        }
        return f[sum] / 2;
    }
}