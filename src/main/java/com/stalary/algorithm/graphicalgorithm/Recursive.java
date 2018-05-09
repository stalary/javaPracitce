package com.stalary.algorithm.graphicalgorithm;

/**
 * recursive
 *
 * @author lirongqian
 * @since 2018/04/11
 */
public class Recursive {

    public static void main(String[] args) {
        // 利用递归查找2的位置
        int[] array = new int[] {
                1, 3, 4, 2, 5
        };
        System.out.println(new Recursive().recursive(array, 3, 0));
    }

    public int recursive(int[] array, int target, int i) {
        if (i == array.length - 1) {
            return -1;
        } else if (array[i] == target) {
            return i;
        }
        return recursive(array, target, i + 1);
    }
}