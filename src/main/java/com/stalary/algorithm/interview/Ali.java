/**
 * @(#)Ali.java, 2018-03-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.interview;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Ali
 *
 * @author lirongqian
 * @since 2018/03/04
 */
public class Ali {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for (int i = 0; i < n; i++) {
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for (int i = 0; i < m; i++) {
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for (int j = 1; j <= n; j++) {
                bomDetail.add(Integer.parseInt(bomInput[j - 1]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for (String key : res.keySet()) {
            System.out.println(key + "*" + res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
        // 首先按权值对bom进行排序
        int len = order.size();
        Set<Wrapper> set = new TreeSet<>(Comparator.comparingDouble(Wrapper::getSum).reversed());
        boms.forEach((k, v) -> {
            double sum = 0.0;
            for (int i = 0; i < len; i++) {
                sum += i / order.get(i);
            }
            Wrapper w = new Wrapper(sum, k, v);
            set.add(w);
        });
        System.out.println(set);
        return new HashMap<>();
    }

    @Data
    @AllArgsConstructor
    static class Wrapper {
        private double sum;

        private String name;

        private List<Integer> count;

    }
}


