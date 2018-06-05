package com.stalary.algorithm.interview;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * Source: (1, 4), (2, 5), (8,9)
 * Result: (1, 5), (8, 9)
 *
 * Example 2:
 * Source: (2, 3), (1, 4), (8,9)
 * Result: (1, 4), (8, 9)
 *
 * Example 3:
 * Source: (8, 9), (2, 3), (1, 4), (6,9)
 * Result: (1, 4), (6, 9)
 *
 * Example 4:
 * Source: (10, 19), (1, 4), (2, 3), (8, 9), (8,10), (17, 23)
 * Result: (1, 4), (8, 23)
 *  1,4 2,3 8,9 8,10, 10,19 17,23
 */

public class MergeRange {


    public List<Range> merge(List<Range> source) {
        // 当起始点相同时，对结束点排序，否则对起始点排序
        source.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });
        System.out.println(source);
        int start = source.get(0).start;
        int end = source.get(0).end;
        int len = source.size();
        List<Range> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int tempStart = source.get(i).start;
            int tempEnd = source.get(i).end;
            if (tempStart > end) {
                result.add(new Range(start, end));
                start = tempStart;
                end = tempEnd;
            } else if (tempStart >= start && tempEnd >= end) {
                end = tempEnd;
            }
        }
        result.add(new Range(start, end));
        return result;
    }

    @Data
    public static class Range {
        public int start;
        public int end;
        public Range(int s, int e){
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new MergeRange().merge(
                        Arrays.asList(
                                new Range(10, 19),
                                new Range(1, 4),
                                new Range(2, 3),
                                new Range(8, 9),
                                new Range(8, 10),
                                new Range(17, 23))));
    }
}