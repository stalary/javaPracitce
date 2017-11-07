package com.stalary.algorithm.algorithmbook;

import java.util.Scanner;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/30
 */
public class Sort {

    ///////////////////////////////////////算法书的排序模版方法///////////////////////////////////////////////

    private static void exchange(int[] a, int i, int j) {//交换两个元素
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    private static void show(int[] a) {//打印出数组
        for(int arr : a) {
            System.out.print(arr + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(int[] a) {//判断数组是否已经排好序
        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //选择排序
    private static void selectSort(int[] a) {
        int len = a.length;
        for(int i = 0; i < len; i++) {
            int min = i;
            for(int j = i + 1; j < len; j++) {
                if(a[j] < a[min]) {
                    min = j;//找到最小值
                }
            }
            exchange(a,i,min);
        }
    }

    //插入排序
    private static void insertSort(int[] a) {
        int len = a.length;
        for(int i = 1; i < len; i++) {
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--) {//与前面的值进行比较，小则交换
                exchange(a, j,j - 1);
            }
        }
    }

    //希尔排序(插入排序的变形)
    private static void shellSort(int[] a) {
        int len = a.length;
        int h = len/2;//确定步长
        while(h >= 1) {
            for(int i = 1; i < len; i++) {
                for(int j = i; j > 0 && a[j] < a[j - 1]; j -= h) {
                    exchange(a, j, j - 1);
                }
            }
            h = h/2;
        }
    }

    private static int[] temp;

    private static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if(high <= low) {
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid ,high);
    }

    private static void merge(int[] a, int low, int mid, int high) {//合并左右两个数组

        int leftIndex = low;//左边数组的游标
        int rightIndex = mid + 1;//右边数组的游标
        temp = new int[a.length];
        for(int k = low; k <= high; k++) {
            temp[k] = a[k];//将数组中的元素全部放入到临时数组中
        }

        for(int k = low; k <= high; k++) {
            if(leftIndex > mid) {
                a[k] = temp[rightIndex++];//左半边用尽，取右半边元素
            } else if(rightIndex > high) {
                a[k] = temp[leftIndex++];//右半边用尽，取左半边元素
            } else if(temp[rightIndex] < temp[leftIndex]) {//取较小的元素，放入数组中
                a[k] = temp[rightIndex++];//右半边的元素小于左半边的元素，取右半边的元素
            } else {
                a[k] = temp[leftIndex++];//右半边的元素大于左半边的元素，取左半边的元素
            }
        }

    }

    private static void quickSort(int[] a) {
        quickSortThree(a, 0 , a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if(high <= low) {
            return;
        }
        int j = partition(a, low, high);//更新临界点
        quickSort(a, low, j - 1);//先从左边进行划分
        quickSort(a, j + 1, high);//再从右边进行划分
    }

    private static void quickSortThree(int[] a, int low, int high) {//三向切分的快速排序的优化
        if(high <= low) {
            return;
        }
        int lt = low,i = low + 1,gt = high;
        int v = a[low];
        while(i <= gt) {
            if(a[i] < v) {
                exchange(a, lt++, i++);
            } else if(a[i] > v) {
                exchange(a, gt--,i);
            } else {
                i++;
            }
        }
        quickSortThree(a, low, lt - 1);
        quickSortThree(a, gt + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int left = low;
        int right = high + 1;
        int v = a[low];
        while(true) {
            while(a[++left] < v) {//从左往右找到大于临界点的值
                if(left == high) {
                    break;
                }
            }
            while(a[--right] > v) {//从右往左找到小于临界点的值
                if(right == low) {
                    break;
                }
            }
            if(left >= right) {//当左边的下标大于右边时，代表查找结束
                break;
            }
            exchange(a, left, right);//交换两边停止的位置，即小于临界点的放左边，大于临界点的放右边
        }
        exchange(a, low, right);//将基数与相遇的点进行交换
        return right;
    }

    private static void heapSort(int[] a) {
        int n = a.length - 1;
        for(int k = n/2; k >= 0; k--) {
            sink(a, k, n);
        }
        for (int i = n; i > 0; i--) {
            exchange(a, 0, i);
            sink(a, 0, i - 1);//将堆的前i - 1项进行调整，因为第i的元素已经是最大的，无需调整
        }
    }

    private static void sink(int[] a, int k, int n) {
        while(2 * k <= n) {
            int j = 2 * k + 1;
            if(j < n && a[j] < a[j + 1]) {
                j++;
            }
            if(j > n) {
                break;
            }
            if(a[k] >= a[j]) {
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            int[] a = new int[]{
                    54,35,48,36,27,12,44,44,8,14,26,17,28
            };
            String choice = in.next();
            if(choice.equals("0")) {
                break;
            }
            long start = System.nanoTime();
            switch (choice) {
                case "select":
                    selectSort(a);
                    break;
                case "insert":
                    insertSort(a);
                case "shell":
                    shellSort(a);
                case "merge":
                    mergeSort(a);
                case "quick":
                    quickSort(a);
                case "heap":
                    heapSort(a);
                default:
                    break;
            }
            long end = System.nanoTime();
            show(a);
            System.out.println("time is : " + (end - start));
            System.out.println(isSorted(a));
        }
    }
}
