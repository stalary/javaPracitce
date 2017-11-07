package com.stalary.algorithm.aha;

/**
 * @author Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class SimpleBucketSort {

    public static void main(String[] args) {
        int[] a = new int[] {
                5,3,5,2,8
        };
        int[] arr = bucketSort(a);
        // 从小到大排序
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j <= arr[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 从大到小排序
        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = 1; j <= arr[i]; j++) {
                System.out.print(i + " ");
            }
        }

    }

    private static int[] bucketSort(int[] a) {
        int max = a[0];
        for(int i = 0; i < a.length; i++) {
            max = Math.max(max,a[i]);
        }
        int[] arr = new int[max + 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for(int i = 0 ; i < a.length; i++) {
            arr[a[i]]++;
        }
        return arr;
    }

}
class People {
    Integer grade;
    String name;

    public People(Integer grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public People() {
    }
}
