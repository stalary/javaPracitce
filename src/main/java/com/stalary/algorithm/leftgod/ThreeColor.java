package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/6
 */
public class ThreeColor {

    public static int[] sortThreeColor(int[] a, int n) {
        int left = -1;
        int right = n;
        int index = 0;
        while(index < right) {
            if(a[index] == 0) {
                swap(a, ++left, index++);//当被交换到左边时，因为交换后的数字已经进行比较过，所以下标要移动1
            } else if(a[index] == 2) {
                swap(a, --right, index);//当被交换到右边时，交换后的数字还未进行比较，所以下标不需要移动
            } else {
                index++;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[] {
                1,2,0,2
        };
        int[] b = sortThreeColor(a, a.length);
        for(int s : b) {
            System.out.print(s + " ");
        }
    }
}
