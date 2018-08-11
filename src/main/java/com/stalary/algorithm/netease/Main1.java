package com.stalary.algorithm.netease;

import java.util.Scanner;

public class Main1 {


    /**
     * 上课清醒时间
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 课程时间
        int n = sc.nextInt();
        // 叫醒清醒时间
        int k = sc.nextInt();
        int[] course = new int[n];
        int[] sleep = new int[n];
        for (int i = 0; i < n; i++) {
            course[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sleep[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n - 2; i++) {
            if (sleep[i] != 1) {
                int count = course[i] + course[i + 1] + course[i + 2];
                if (count > max) {
                    max = count;
                    index = i;
                }
            }
        }
        for (int i = index; i < index + 3; i++) {
            sleep[i] = 1;
        }
        int out = 0;
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 1) {
                out += course[i];
            }
        }
        System.out.println(out);
    }
}