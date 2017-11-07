package com.stalary.algorithm.algorithmbook;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/18
 */

/**
 * 只能对已排序的数组使用
 * */
public class BinarySearch {

    public static int search(int key, int[] a) {

        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(key < a[mid]) {
                end = mid - 1;
            } else if(key > a[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[] {3,4,7,1,8,3,2};
        Arrays.sort(a);//先排序才可以使用二分查找
        while(true) {
            System.out.println("输入要查找的元素,输入00结束");
            int key = in.nextInt();
            if(key == 00) {
                break;
            }
            if (search(key, a) < 0) {
                System.out.println("未找到该元素");
            } else {
                System.out.println("该元素的位置是：" + search(key, a));
            }
        }
    }
}
