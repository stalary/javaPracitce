package com.stalary.algorithm.toutiao2019; /**
 * @(#)Main3.java, 2018-08-12.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * com.stalary.algorithm.toutiao2019.Main3
 *
 * @author lirongqian
 * @since 2018/08/12
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int person = sc.nextInt();
            int team = sc.nextInt();
            pointList.add(new Point(person, team, (double) team / person));
        }
        pointList.sort(Comparator.comparingDouble(point -> -point.weight));
        List<Point> aList = new ArrayList<>();
        List<Point> bList = new ArrayList<>();
//        Li
        System.out.println(pointList);
    }

    public static class Point {
        public int person;

        public int team;

        public double weight;

        public Point(int person, int team, double weight) {
            this.person = person;
            this.team = team;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "person=" + person +
                    ", team=" + team +
                    ", weight=" + weight +
                    '}';
        }
    }
}