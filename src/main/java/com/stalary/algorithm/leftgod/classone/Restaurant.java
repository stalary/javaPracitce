package com.stalary.algorithm.leftgod.classone;

import java.util.*;

/**
 * @author stalary
 */
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] disk = new int[n]; //桌子数组
            for (int i = 0; i < n; i ++) {
                disk[i] = sc.nextInt();
            }
            Arrays.sort(disk); // 桌子容纳量从小到大排序
            PriorityQueue<Customer> queue = new PriorityQueue<>(); // 将客人按消费额降序加入优先级队列
            for (int i = 0; i < m; i ++) {
                int b = sc.nextInt();
                int c = sc.nextInt();
                if(b <= disk[n - 1]) queue.add(new Customer(b, c)); // 如果人数小于桌子最大容纳量,加入队列
            }
            boolean[] visited = new boolean[n]; // 记录桌子是否被占用
            long sum = 0; // 记录总盈利
            int count = 0; // 记录已使用的桌子数
            while ( ! queue.isEmpty()) {
                Customer customer = queue.poll();
                for (int i = 0; i < n; i ++) { // 为客人分配桌子
                    if(customer.peopleCount <= disk[i] && ! visited[i]) {
                        sum += customer.moneyCount;
                        visited[i] = true;
                        count ++;
                        break;
                    }
                }
                if(count == n) break;
            }
            System.out.println(sum);
        }
    }

    static class Customer implements Comparable<Customer> {
        private int peopleCount;
        private int moneyCount;

        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }

        @Override
        public int compareTo(Customer o) {
            if(o.moneyCount > this.moneyCount) {
                return 1;
            }
            else if(o.moneyCount < this.moneyCount)  {
                return - 1;
            }
            return 0;
        }
    }
}