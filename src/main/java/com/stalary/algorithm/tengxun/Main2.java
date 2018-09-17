package com.stalary.algorithm.tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 城市数
        int n = in.nextInt();
        // 道路数
        int m = in.nextInt();
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new Edge(a, b));
        }
        int[] num = new int[n + 1];
        list.forEach(edge -> {
            num[edge.a]--;
            num[edge.b]++;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).b == edge.a) {
                    num[edge.b]++;
                }
            }
        });
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (num[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Edge {
        int a;
        int b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}