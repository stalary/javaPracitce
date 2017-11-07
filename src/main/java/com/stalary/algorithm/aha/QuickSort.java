package com.stalary.algorithm.aha;

import java.util.Scanner;

/**
 * @author Stalary
 * @description 快速排序
 * @date 2017/10/15
 */
public class QuickSort {

    /**
     * @param a-》数组
     * @param left-》左侧起点
     * @param right-》右侧起点 快速排序主要思想：通过确定一个基数，然后把比基数小的放到基数的左边，比基数大的放到基数的右边从而进行排序
     *                    1：确定最左边的数为基数
     *                    2：让右边先开始移动，查找比基数小的数
     *                    3：左边开始移动，查找比基数大的数
     *                    4：交换两个数字，继续移动
     *                    5：当两边指针相遇时，交换基数和相遇点的数字
     *                    6：采用二分的方法，对基数左右两边进行排序
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        // 确立基数为最左边的值
        int key = a[left];
        int l = left;
        int r = right;
        // 当两边元素为相遇时继续查找
        while (l != r) {
            // 先从右边开始查找比基数小的值
            while (a[r] >= key && l < r) {
                r--;
            }
            while (a[l] <= key && l < r) {
                l++;
            }
            // 从左往右找到比基数大的值和从右往左找到比基数小的值后，未相遇时，将两个值进行交换
            if (l < r) {
                swap(a, r, l);
            }
        }
        // 相遇时，交换基数与相遇点，因为上面已有key可以作为临时变量，所以省略交换的第一个赋值的步骤
        a[left] = a[l];
        a[l] = key;

        // 运用二分法的思想，继续处理左边和右边的元素
        quickSort(a, left, l - 1);
        quickSort(a, l + 1, right);
    }

    /**
     * 交换函数，需要传入数组，和两个需要交换元素的下标
     *
     * @param a-》数组
     * @param i-》第一个待交换元素的下标
     * @param j-》第二个待交换元素的下标
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入数组长度");
        int[] a = new int[in.nextInt()];
        System.out.println("输入数组元素");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        System.out.println("待排序数组为");
        for (int noSort : a) {
            System.out.print(noSort + " ");
        }
        System.out.println();
        System.out.println("排序后的数组为");
        quickSort(a, 0, a.length - 1);
        for (int noSort : a) {
            System.out.print(noSort + " ");
        }
    }
}
