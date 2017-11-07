package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/6
 */
public class repeatElement {

    public static boolean check(int[] a, int n) {
        for(int i = 1; i < n; i++) {
            if(a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[] {
                1,2,3,4,5,5,6
        };
        System.out.println(check(a, 7));
    }
}
