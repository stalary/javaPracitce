package com.stalary.algorithm.toutiao2019; /**
 * @(#)Main.java, 2018-08-12.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/08/12
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            courseList.add(new Course(sc.nextInt(), sc.nextInt()));
        }
        courseList.sort(Comparator.comparing(course -> course.interval));
        int count = 0;
        int sum = 0;
        for (Course course : courseList) {
            sum += course.interval;
            if (course.special) {
                count++;
                System.out.println(count);
                break;
            }
            if (sum > k) {
                System.out.println(count);
                break;
            } else {
                count++;
            }
        }
    }

    public static class Course {
        public int start;

        public int end;

        public int interval;

        public boolean special;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
            this.interval = Math.abs(end - start);
            if (end - start < 0) {
                special = true;
            }
        }

        @Override
        public String toString() {
            return "Course{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}