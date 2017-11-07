package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/6
 */
public class TwoFinder {

    public static boolean findX(int[][] a, int n, int m, int x) {
        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j >= 0; j--) {
                if(x > a[i][j]) {
                    break;
                } else if(x < a[i][j]) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(findX(a, 3, 3, 9));
    }
}
