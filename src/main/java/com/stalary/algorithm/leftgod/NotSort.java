package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/6
 */
public class NotSort {

    public static Integer calculate(int[] A, int n) {
        int max = A[0], min = A[n - 1], r = 0, l = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            } else if (A[i] < max) {
                r = i;
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            if (A[j] < min) {
                min = A[j];
            } else if (A[j] > min) {
                l = j;
            }
        }
        if (r - l == 0) return 0;
        else return r - l + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 6, 5, 8, 9
        };
        System.out.println(calculate(a, a.length));
    }
}
