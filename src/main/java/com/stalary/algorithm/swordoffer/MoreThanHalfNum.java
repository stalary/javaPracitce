/**
 * @(#)MoreThanHalfNum.java, 2017-12-19.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * MoreThanHalfNum
 * 找到数组中重复的个数大于数组的一半的元素
 * @author lirongqian
 * @since 19/12/2017
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        };
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(arr));
    }

    /**
     *  使用hashmap来记录元素出现的次数
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int out : array) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        for (int out : map.keySet()) {
            if (map.get(out) > array.length / 2) {
                return out;
            }
        }
        return 0;
    }

    /**
     * 首先假定一个元素，遇到相同的加一，不同的减1，当为0时则换一个元素进行检测，然后判断最后留下的元素的数量是否超过了数组的一半即可
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }

        if (times * 2 < length) {
            result = 0;
        }
        return result;
    }


}