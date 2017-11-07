package com.stalary.algorithm.interview;

/**
 * @author Stalary
 * @description 两块为排好序的数组 99 100 1 3 6 9 10 12中查找10，返回6
 * @date 2017/10/18
 */
public class SearchNoSort {

    public static void main(String[] args) {
        int[] a = new int[]{
                99, 100, 1, 3, 6, 9, 10, 12
        };
        System.out.println(searchTemp(a, 10));
    }

    /**
     * 查找临界点，顺便判断临界点是否为查找值
     *
     * @return int->下标
     */
    private static int searchTemp(int[] a, int key) {
        // 记录临界点
        int temp = 0;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2;

            /////////////// 开始剪纸 ///////////////////
            // 若查找到值则直接返回
            if(a[mid] == key) {
                return mid;
            }
            // 当待查找值处于左侧有序区域时，直接进行二分查找
            if (key >= a[0] && key <= a[mid]) {
                return searchIndex(a, start, mid, key);
            }
            // 当待查找值处于右侧有序区域时，直接进行二分二分查找
            if (key < a[0] && key >= a[mid]) {
                return searchIndex(a, mid, end, key);
            }
            //////////////// 结束剪枝 ///////////////////

            // 判断临界点的条件
            if (a[mid] >= a[0] && a[mid] > a[mid + 1]) {
                // 找到临界点
                temp = mid;
                // 如果临界点为所要查找的值，直接返回临界点的下标
                if(a[temp] == key) {
                    return temp;
                }
                // 找到临界点，跳出
                break;
            } else {
                // 如果小于初始值，则从左侧进行查找临界点
                if (a[mid] < a[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        int out;
        // 若查找左边就找到，直接返回，否则继续查找右边元素
        out = searchIndex(a, 0, temp - 1, key);
        if(out == -1) {
            out = searchIndex(a, temp + 1, a.length - 1, key);
        }
        return out;
    }

    /**
     * 基本二分方法
     * @param a->数组
     * @param left->起始点
     * @param right->终点
     * @param key->查找的值
     * @return
     */
    private static int searchIndex(int[] a, int left, int right, int key) {
        int start = left;
        int end = right;
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
}
