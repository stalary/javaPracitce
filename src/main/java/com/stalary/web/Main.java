package com.stalary.web;

import java.util.*;

public class Main {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        for (char c : str.toCharArray()) {
            int temp = c - 48;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        System.out.println(map);
        boolean flag = false;
        for (int i = 1; i < 10; i++) {
            if (map.get(i) == null) {
                flag = true;
                System.out.println(i);
                break;
            }
        }
        if (!flag) {
            for (int i = 10; i < 10000; i++) {
                int[] num = get(i);
                System.out.println(Arrays.toString(num) + " " + i);
                for (int j = 0; j < 10; j++) {
                    if (map.get(j) == null || map.get(j) < num[j]) {
                        System.out.println(i);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }

    public static int[] get(int i) {
        int[] num = new int[10];
        while (i >= 10) {
            num[i % 10]++;
            i = i / 10;
        }
        num[i]++;
        return num;
    }
}


