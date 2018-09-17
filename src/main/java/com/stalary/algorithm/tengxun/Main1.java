package com.stalary.algorithm.tengxun; /**
 * @(#)Main.java, 2018-09-09.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.Scanner;

/**
 * @author lirongqian
 * @since 2018/09/09
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Point point = new Point(a, b, c);
            boolean flag = judge(point);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean judge(Point point) {
        for (int i = 1; point.a * i < 100000; i++) {
            if (point.a * i % point.b == point.c) {
                return true;
            }
        }
        return false;
    }

    public static class Point {
        Integer a;
        Integer b;
        Integer c;

        public Point(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }
}