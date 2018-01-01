/**
 * @(#)IsContinuous.java, 2018-01-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.Arrays;

/**
 * IsContinuous
 *
 * @author lirongqian
 * @since 01/01/2018
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] numbers = new int[] {
                1,0,1,0,0
        };
        System.out.println(new IsContinuous().isContinuous(numbers));
    }

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max;
        int[] temp = new int[numbers.length];
        System.arraycopy(numbers, 0, temp, 0 , temp.length);
        Arrays.sort(temp);
        // 查找最小值
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                if (temp[i] < min) {
                    min = temp[i];
                }
            }
        }
        max = temp[temp.length - 1];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != 0) {
                if (temp[i] == temp[i -1]) {
                    return false;
                }
            }
        }
        if (max == min) {
            return true;
        }
        int[] sort = new int[max - min + 1];
        int index = 0;
        for (int i = min; i <= max; i++) {
            sort[index++] = i;
        }
        if (Arrays.equals(sort, temp)) {
            return true;
        } else {
            if (temp[0] != 0) {
                return false;
            }
        }
        int j;
        if (sort.length < temp.length) {
            return true;
        }
        for (j = 0; j < temp.length; j++) {
            if (temp[j] == sort[0]) {
                break;
            }
        }
        int num = 0;
        for (int i = 0; i < temp.length; i++) {
                if (temp[j] != sort[i]) {
                    num++;
                } else {
                    j++;
                }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                num--;
            }
        }
        return num == 0;
    }

    public boolean isContinuous1(int [] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) {
                return false;
            }
            if (number == 0) {
                continue;
            }
            if (((flag >> number) & 1) == 1) {
                return false;
            }
            flag |= (1 << number);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}