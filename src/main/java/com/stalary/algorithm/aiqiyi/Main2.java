package com.stalary.algorithm.aiqiyi; /**
 * @(#)Main.java, 2018-09-15.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.*;

/**
 * com.stalary.algorithm.aiqiyi.Main2
 *
 * @author lirongqian
 * @since 2018/09/15
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i + 1, in.nextInt());
        }
        for (int i = 0; i < m; i++) {
            String s = in.next();
            int num = in.nextInt();
            if ("A".equals(s)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, map.get(num) - 1);
            }
        }
        Set<Integer> integers = sortByValue(map, true).keySet();
        int index = 1;
        Iterator<Integer> it = integers.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp == p) {
                System.out.println(index);
                break;
            } else {
                index++;
            }
        }
    }

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map, final boolean reverse) {
        List list = new LinkedList(map.entrySet());
        list.sort((o1, o2) -> {
            if (reverse) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
            return ((Comparable) ((Map.Entry) (o1)).getValue())
                    .compareTo(((Map.Entry) (o2)).getValue());
        });
        Map result = new LinkedHashMap();
        for (Object aList : list) {
            Map.Entry entry = (Map.Entry) aList;
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}