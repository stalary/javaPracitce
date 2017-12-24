/**
 * @(#)GetUglyNumber.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * GetUglyNumber
 *
 * @author lirongqian
 * @since 24/12/2017
 */
public class GetUglyNumber {

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(7));
    }

    /**
     * 排序就是将2，3，5出现的次数依次增大
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i)
        {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) {
                t2++;
            }
            if (res[i] == res[t3] * 3) {
                t3++;
            }
            if (res[i] == res[t5] * 5) {
                t5++;
            }
        }
        return res[index - 1];

    }

}