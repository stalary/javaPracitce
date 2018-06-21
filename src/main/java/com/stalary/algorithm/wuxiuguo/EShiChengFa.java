/**
 * @(#)EShiChengFa.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * EShiChengFa
 *
 * @author lirongqian
 * @since 2018/06/20
 */
public class EShiChengFa {

    public static void main(String[] args) {
        System.out.println(test(50, 65));
    }

    public static int test(int n, int m) {
        int sum = 0;
        while (n >= 1) {
           if (n % 2 == 0) {
               n = n / 2;
               m = m * 2;
           } else {
               n = (n - 1) / 2;
               sum += m;
               m = m * 2;
           }
        }
        return sum;
    }
}