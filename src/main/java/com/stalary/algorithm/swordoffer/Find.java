/**
 * @(#)FindInTwoDimensionArray.java, 2017-11-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * Find
 *
 * 二维数组中的查找，因为每一行递增，每一列递增，所以右下角是最大的
 * @author lirongqian
 * @since 2017/11/27
 */
public class Find {

    public static void main(String[] args) {

    }

    /**
     * 可知左上角为最小值，右下角为最大值，我们可以选择左下角或者右上角进行查找
     * 选择右上角进行查找，如果目标值小于当前值，则列数-1，大于当前值，则行数+1，等于时即为找到该值
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        if (array.length == 0) {
            return false;
        }
        int row = 0;
        int col = array.length - 1;
        while (col >= 0 && row < array[0].length) {
            if (target < array[row][col]) {
                col--;
            } else if (target > array[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}