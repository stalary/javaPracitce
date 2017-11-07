package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/6
 */
public class Merge {

    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{
                1, 2, 3, 0, 0, 0, 0
        };
        int[] B = new int[]{
                4, 6, 8, 10
        };
        int[] M = mergeAB(A, B, 3, 4);
        for (int s : M) {
            System.out.print(s + " ");
        }
    }
}
