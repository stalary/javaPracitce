/**
 * @(#)Subset.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset
 * 数组子集
 * @author lirongqian
 * @since 2018/06/20
 */
public class Subset {

    public static void main(String[] args) {
        int[] num = new int[]{
                1, 3, 2
        };
        System.out.println(new Subset().subsets(num));
    }

    public List<List<Integer>> getSubset(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        // 子集总共含有2的数组长度次方个
        int max = 1 << num.length;
        for (int i = 0; i < max; i++) {
            int index = 0;
            int k = i;
            List<Integer> s = new ArrayList<>();
            while (k > 0) {
                if ((k & 1) > 0) {
                    s.add(num[index]);
                }
                k >>= 1;
                index++;
            }
            result.add(s);
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param nums 数组
     * @param index 当前下标
     * @param res 结果
     * @param subset 传入的子集
     */
    public void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        // 下标等于长度时，代表完成一次排列
        if (index == nums.length) {
            res.add(subset);
            return;
        }
        // 递归，移动下标
        subsets(nums, index + 1, res, subset);
        ArrayList<Integer> list = new ArrayList<>(subset);
        // 递归完成后回溯开始增加元素
        list.add(nums[index]);
        subsets(nums, index + 1, res, list);
    }
}