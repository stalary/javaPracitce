/**
 * @(#)Fi.java, 2018-06-23.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * Fi
 *
 * @author lirongqian
 * @since 2018/06/23
 */
public class Fi {

    public static void main(String[] args) {
        System.out.println(fi(5));
    }

    public static int fi(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        return fi(n, f);
    }

    public static int fi(int n, int[] f) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fi(n - 1, f) + fi(n - 2, f);
        return f[n];
    }
}