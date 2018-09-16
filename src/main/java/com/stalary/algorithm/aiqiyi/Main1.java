package com.stalary.algorithm.aiqiyi; /**
 * @(#)Main1.java, 2018-09-09.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.*;

/**
 * com.stalary.algorithm.aiqiyi.Main1
 *
 * @author lirongqian
 * @since 2018/09/09
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] num1 = new int[3];
        int[] num2 = new int[3];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 3; i++) {
            int temp = str.charAt(i) - '0';
            num1[i] = temp;
            sum1 += temp;
        }
        for (int i = 3; i < 6; i++) {
            int temp = str.charAt(i) - '0';
            num2[i - 3] = temp;
            sum2 += temp;
        }
        if (sum1 == sum2) {
            System.out.println(0);
        } else {
            Arrays.sort(num1);
            Arrays.sort(num2);
            if (sum1 < sum2) {
                int sum = sum2 - sum1;
                sum = sum - (9 - num1[0]);
                if (sum <= 0) {
                    System.out.println(1);
                } else {
                    sum = sum - (9 - num1[1]);
                    if (sum <= 0) {
                        System.out.println(2);
                    } else {
                        sum = sum - (9 - num1[2]);
                        if (sum <= 0) {
                            System.out.println(3);
                        } else {
                            System.out.println(3);
                        }
                    }
                }
            } else {
                int sum = sum1 - sum2;
                sum = sum - (9 - num2[0]);
                if (sum <= 0) {
                    System.out.println(1);
                } else {
                    sum = sum - (9 - num2[1]);
                    if (sum <= 0) {
                        System.out.println(2);
                    } else {
                        sum = sum - (9 - num2[2]);
                        if (sum <= 0) {
                            System.out.println(3);
                        } else {
                            System.out.println(3);
                        }
                    }
                }
            }

        }
    }

}