package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/5
 */
public class ScaleSort {

    public static int[] sortElement(int[] A, int n, int k) {
        createHeap(A, k);
        int temp = 0;
        int[] arr = new int[n];//存储排序后的数组
        //继续往小根堆里扩数
        int j = 0;
        for (int i = k; i < n; i++, j++) {
            arr[j] = A[0];//取最小堆的堆顶元素
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            sink(A, 0, k);

        }
        System.out.println(j);
        //将最后一个最小堆里的值按从小到大的顺序输出
        for (int i = k - 1; i >= 0; i--, j++) {
            arr[j] = A[0];//取最小堆的堆顶元素
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            sink(A, 0, i);
        }

        return arr;
    }

    public static void createHeap(int[] A, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            sink(A, i, k);
        }
    }

    public static void sink(int[] A, int r, int k) {//建立小根堆
        while (2 * r + 1 < k) {
            int c = 2 * r + 1;
            if (c < k - 1 && A[c] > A[c + 1]) {//如果左儿子比右儿子大，则选择右儿子
                c++;
            }
            if (A[c] < A[r]) {//如果子结点小于根结点，则交换
                int temp = A[c];
                A[c] = A[r];
                A[r] = temp;
                r = c;
            } else {
                break;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                2,1,4,3,6,5,8,7,10,9
        };
        int[] arr = sortElement(a, a.length, 2);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
