/**
 * @(#)PascalsTriangle118.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * PascalsTriangle118
 *
 * 输出一个pascal三角形
 *           1
 *         1   1
 *       1   2   1
 *     1   3   3   1
 * @author lirongqian
 * @since 24/12/2017
 */
public class PascalsTriangle118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = new PascalsTriangle118().generate(3);
        System.out.println(generate);
    }

    /**
     * 可以发现每次的最后一个元素和第一个元素都是1，而中间的元素是上一行的两个元素相加
     * 所以可以每次都在第一个元素处插入1，然后不改变末尾的1，中间的元素修改为上面的两个元素相加
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }
}