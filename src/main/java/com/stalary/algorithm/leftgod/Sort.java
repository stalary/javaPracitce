package com.stalary.algorithm.leftgod;

import java.util.Scanner;

/**
 * @author Stalary
 * @description: 各种基本排序的实现
 * @date Created in 2017/9/19
 */
public class Sort {

    //////////////////////////时间复杂度为O(n^2)///////////////////////////////////////////////


    /**
     * 冒泡排序
     */
    private static int[] bubbleSort(int[] a, int n) {
        if (a == null || n < 2) {
            return a;
        }
        // 首先比较整体数组，最大数放到数组的最后，每次循环缩小1
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, i, j);
                }
            }
        }
        return a;
    }

    /**
     * 选择排序
     */
    private static int[] selectSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            // 当前下标作为最小值
            int min = i;
            // 先选出最小值，放到位置零上，然后以此类推，依次进行交换
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    // 当下标对应的值大于当前值时，交换下标值
                    min = j;
                }
            }
            // 当前下标和初始下标不相同时，进行交换
            if (min != i) {
                swap(a, min, i);
            }
        }
        return a;
    }

    /**
     * 插入排序，与之前的数进行依次比较，如果小则交换
     */
    private static int[] insertSort(int[] a, int n) {
        if (a == null || n < 2) {
            return a;
        }
        for (int i = 1; i < n; i++) {
            // 当小于前一个值时，就向前交换
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }

    private static int[] insertSort1(int[] a, int n) {
        if (a == null || n < 2) {
            return a;
        }
        int target;
        for (int i = 1; i < n; i++) {
            int j = i;
            target = a[i];
            while (j > 0 && target < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = target;
        }
        return a;
    }

    /**
     * shell排序，步长每次缩小一半，是插入排序的变形
     */
    private static int[] shellSort(int[] a, int n) {
        if (a == null || n < 2) {
            return a;
        }
        // 确定步长
        int feet = n / 2;
        while (feet >= 1) {
            for (int i = feet; i < n; i++) {
                for (int j = i; j >= feet && a[j] < a[j - feet]; j -= feet) {
                    swap(a, j, j - feet);
                }
            }
            // 每次步长减半
            feet = feet >> 1;
        }
        return a;
    }

    ////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////时间复杂度为O(n*logn)///////////////////////////////////////

    /**
     * mergeSort，因为需要使用递归，所以进行模块分化
     */
    private static int[] mergeSort(int[] a, int n) {
        mSort(a, 0, n - 1);
        return a;
    }

    private static void mSort(int[] a, int left, int right) {

        // 递归的第一步都是进行设置边界
        if (left >= right) {
            return;
        }
        //计算中间值，每次都取一半进行划分
        int mid = (left + right) / 2;
        //划分左右
        mSort(a, left, mid);
        mSort(a, mid + 1, right);
        //合并左右
        merge(a, left, mid, right);
    }

    /**
     * 9 8 7 6 4 5 1 6 -> 8 9|6 7|4 5|1 6 -> 8 9 6 7|4 5 1 6
     * 左边的mid为1，所以temp为6 7然后将左边数组全部放入，实现排序
     * 右边mid为5，所以temp为1 4 5，然后将6放入，实现排序
     * 6 7 8 |9| 1 4 5 6
     * mid为3，即9，所以temp为1 4 5 6然后将左边数组全部放入，完成排序
     * 需要大小为n的辅助数组，所以空间复杂度为n
     *
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] a, int left, int mid, int right) {//合并左右两个数组

        // 临时数组
        int[] temp = new int[right - left + 1];
        // 左边数组的游标
        int leftIndex = left;
        // 右边数组的游标
        int rightIndex = mid + 1;
        // 临时数组的游标
        int tempIndex = 0;

        // 选择左右数组中的小数字存入临时数组，并移动游标
        while (leftIndex <= mid && rightIndex <= right) {
            if (a[leftIndex] < a[rightIndex]) {
                temp[tempIndex++] = a[leftIndex++];
            } else {
                temp[tempIndex++] = a[rightIndex++];
            }
        }

        // 将剩余的数字放入临时数组
        while (leftIndex <= mid) {
            temp[tempIndex++] = a[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[tempIndex++] = a[rightIndex++];
        }

        // 将临时数组放回原数组中实现排序
        int t = 0;
        while ((t + left) <= right) {
            a[t + left] = temp[t];
            t++;
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * quickSort，递归使用，进行模块分化，因为使用了递归，所以需要logn的空间
     */
    public static int[] quickSort(int[] A, int n) {
        quickSort(A, 0, n - 1);
        return A;
    }

    private static void quickSort(int A[], int left, int right) {
        if (left >= right) {
            return;
        }
        //取最左边的值作为界限，所以要从右边开始排序
        int key = A[left];
        int l = left;
        int r = right;
        while (l < r) {
            //直到找到小于界限值的数
            while (l < r && A[r] >= key) {
                r--;
            }
            //直到找到大于界限值的数
            while (l < r && A[l] <= key) {
                l++;
            }
            int temp = A[r];
            A[r] = A[l];
            A[l] = temp;
        }
        //左右两侧查找相遇，基数归位，A[l]为相遇点
        A[left] = A[l];
        A[l] = key;
        //从左右两侧继续查找
        quickSort(A, left, l);
        quickSort(A, l + 1, right);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * heapSort，循环调用，进行模块划分
     */
    private static int[] heapSort(int[] a, int n) {
        // 建大根堆,每次取子结点的根结点，依次进行比较
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, n - 1);
        }
        // 排序
        for (int i = n - 1; i > 0; i--) {
            // 将最大值放到最后
            swap(a, i, 0);
            // 将堆的前️i - 1项进行调整，因为第i的元素已经是最大的，无需调整
            heapAdjust(a, 0, i - 1);
        }

        return a;
    }

    private static void heapAdjust(int[] a, int i, int m) {
        // 2 * i + 1即为子结点，+1是与建堆的-1相对应的
        while (2 * i + 1 <= m) {
            int k = 2 * i + 1;
            // 找出最大的子结点
            if (k < m && a[k] < a[k + 1]) {
                k++;
            }
            // 将子结点与根结点进行比较，若子结点较大，则进行交换
            if (a[k] > a[i]) {
                swap(a, k, i);
                i = k;
            } else {
                break;
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////


    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////不基于比较的排序/////////////////////////////////////////////////

    /**
     * 计数排序，申请一定数量的数组，出现就将桶倒出，倒出的顺序即为排序的顺序
     */
    public static int[] countSort(int[] arr, int length) {
        if (arr == null || length < 2) {
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int[] countArr = new int[max - min + 1];//只申请元素差大小的数组，使用时加上起始数值
        for (int i = 0; i < length; i++) {
            countArr[arr[i] - min]++;//将出现的元素装入桶中
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;//将桶倒出，即为排序后的数组
            }
        }
        return arr;
    }


    /***
     * 基数排序，申请0-9的数组，先按第一位存入，弹出，再第二位，以此类推
     */
    private static int[] radixSort(int[] a, int n) {
        //高维表示0-9个桶，低维表示每个关键字各个位上的余数,每个桶内可能有n个值
        int[][] b = new int[10][n];
        //创建一个数组表示B数组的每一个桶里面的数目
        int[] c = new int[10];
        int p;

        for (int i = 1; i <= 1000; i *= 10) {
            for (int j = 0; j < n; j++) {
                // 取出每一位的数
                p = a[j] / i % 10;
                // 位数对应的桶所存储的数值，然后修改桶内元素的数量
                b[p][c[p]++] = a[j];
            }

            p = 0;
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c[j]; k++) {
                    // 将桶内元素依次倒出
                    a[p++] = b[j][k];
                    b[j][k] = 0;
                }
                c[j] = 0;
            }
        }

        return a;
    }

    //////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 5, 2, 7};
        int length = a.length;
        System.out.println("please you want to use sort type，input e exit");
        Scanner in = new Scanner(System.in);
        while (true) {
            String type = in.next();
            if ("e".equals(type)) {
                break;
            }
            switch (type) {
                case "bubble":
                    a = bubbleSort(a, length);
                    break;
                case "select":
                    a = selectSort(a, length);
                    break;
                case "insert":
                    a = insertSort(a, length);
                    break;
                case "merge":
                    a = mergeSort(a, length);
                    break;
                case "quick":
                    a = quickSort(a, length);
                    break;
                case "heap":
                    a = heapSort(a, length);
                    break;
                case "shell":
                    a = shellSort(a, length);
                    break;
                case "count":
                    a = countSort(a, length);
                    break;
                case "radix":
                    a = radixSort(a, length);
                    break;
                default:
                    System.out.println("输入错误");
            }
            for (int out : a) {
                System.out.print(out + " ");
            }
            System.out.println();
        }

    }
}
