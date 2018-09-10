package com.stalary.algorithm.toutiao2019; /**
 * @(#)Main1.java, 2018-08-12.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * com.stalary.algorithm.toutiao2019.Main
 *
 * @author lirongqian
 * @since 2018/08/12
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            String[] split = line.split(";");
            for (String str : split) {
                String[] split1 = str.split(",");
                intervalList.add(new Interval(Integer.valueOf(split1[0]), Integer.valueOf(split1[1])));
            }
        }
        List<Interval> merge = merge(intervalList);
        StringBuilder sb = new StringBuilder();
        merge.forEach(interval -> sb.append(interval.start).append(",").append(interval.end).append(";"));
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() < 1) {
            return res;
        }
        // 当两个的开始时间不同时，将开始时间大的放在后面，否则将结束时间大的放在后面
        intervals.sort((interval1, interval2) -> {
            if (interval1.start != interval2.start) {
                return interval1.start - interval2.start;
            }
            return interval1.end - interval2.end;
        });
        // 获取第一个的开始和结束的位置
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval it : intervals) {
            // 当开始小于等于结束时，返回结束的最大值，包含最多的元素s
            if (it.start <= end) {
                end = Math.max(it.end, end);
            } else {
                // 否则添加，然后向后移动
                res.add(new Interval(start, end));
                start = it.start;
                end = it.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}