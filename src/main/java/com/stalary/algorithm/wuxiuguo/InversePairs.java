package com.stalary.algorithm.wuxiuguo;

/**
 * InversePairs
 * <p>
 * 计算逆序对的数量，前面数字大于后面的数字，即代表一个逆序对
 * @author lirongqian
 * @since 2018/02/07
 */
public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return inversePairsCore(array, copy, 0, array.length - 1);
    }

    /**
     * 实际上是归并排序的过程
     *
     * @param array
     * @param copy
     * @param low
     * @param high
     * @return
     */
    private int inversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        // 递归拆分数组，分到只有一个数据项
        int leftCount = inversePairsCore(array, copy, low, mid);
        int rightCount = inversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        // 设置左侧数组范围为i，右侧数组范围为j
        int i = mid;
        int j = high;
        // 当前判断的下标
        int locCopy = high;
        while (i >= low && j > mid) {
            // 当前面的元素较大时，统计一下数量
            if (array[i] > array[j]) {
                // 单块的内部已经排好序，所以如果最小的比后面的大的话，会都大
                count += j - mid;
                // 满足逆序对时，左侧元素向前移动
                copy[locCopy--] = array[i--];
            } else {
                // 当不满足逆序对时，右侧元素向前移动
                copy[locCopy--] = array[j--];
            }
        }
        // 左侧元素归位
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        // 右侧元素归位
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        // 将元素放回原数组，完成排序
        System.arraycopy(copy, low, array, low, high + 1 - low);
        return leftCount + rightCount + count;
    }
}