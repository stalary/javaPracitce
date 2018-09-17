package com.stalary.algorithm.tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        init();
        System.out.println(solve(n));
    }


    private static int solve(int n) {
        List<Integer> list = new ArrayList<>();
        for (Integer prim : prims) {
            if (prim > n) {
                break;
            }
            int a = (int) (Math.log10(n) / Math.log10(prim));
            list.add((int) Math.pow(prim, a));
        }
        int ans = -1;
        for (Integer i : list) {
            int t = (n + 1) / i * i;
            if (t < n + 1) {
                t += i;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    private static Integer[] prims;

    private static void init() {
        // 获取1000000以内的素数加入到list中
        boolean[] flag = getPrime(1000000);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < flag.length; i++) {
            if (flag[i]) {
                list.add(i);
            }
        }
        prims = new Integer[list.size()];
        list.toArray(prims);
    }

    private static boolean[] getPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < isPrime.length; i += 2) {
            isPrime[i] = true;
        }
        int size = (int) Math.sqrt(n);
        int tmp;
        for (int i = 3; i <= size; i++) {
            if (!isPrime[i]) {
                tmp = i * 2;
                for (int j = i * i; j < isPrime.length; j += tmp) {
                    isPrime[j] = true;
                }
            }
            isPrime[i] = !isPrime[i];
        }
        for (int i = Math.max(3, size + 1); i < isPrime.length; i++) {
            isPrime[i] = !isPrime[i];
        }
        return isPrime;
    }
}