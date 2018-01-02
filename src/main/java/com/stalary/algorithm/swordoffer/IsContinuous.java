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
 * <p>
 * 给定几张牌，判断是否可以作为顺子，0可以代表任意的牌
 *
 * @author lirongqian
 * @since 01/01/2018
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] numbers = new int[]{
                1, 0, 3, 4
        };
        System.out.println(new IsContinuous().isContinuous(numbers));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null) {
            return false;
        }
        // 顺子由五张牌组成
        if (numbers.length < 5) {
            return false;
        }
        // 排序
        Arrays.sort(numbers);
        // 拿到除0以外的最小值
        int zero = 0;
        int i = 0;
        // 统计0的数量
        for (; i < numbers.length && numbers[i] == 0; i++) {
            zero++;
        }
        // 从非0处开始遍历，若有相同元素则不能组成顺子
        for (; i < numbers.length - 1 && zero >= 0; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            // 如果当前元素加1加上剩余0的数量大于下一个元素，则说明可以到达下一个元素
            if (numbers[i] + 1 + zero >= numbers[i + 1]) {
                // 减去使用的0
                zero -= numbers[i + 1] - numbers[i] - 1;
            } else {
                return false;
            }
        }
        // 如果i可以到达末尾，则说明可以组成顺子
        return i == numbers.length - 1;
    }

    public boolean isContinuous1(int[] numbers) {
        // 顺子由五张牌组成
        if (numbers.length != 5) {
            return false;
        }
        // 顺子最大13，最小1，特殊牌为0
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            // 如果存在非法的值则跳出
            if (number < 0 || number > 13) {
                return false;
            }
            // 当前数字为特殊值，则继续
            if (number == 0) {
                continue;
            }
            // 如果有非0的重复数字则无法组成顺子
            // 将1右移numbers[i]位，然后与flag进行按位与运算
            // 若flag上的第numbers[i]已为1，说明该位已被占用，数字重复了，运算的结果大于0,返回false
            if (((1 << number) & flag) > 0) {
                return false;
            }
            // 通过“或操作”填充flag中不同的二进制位
            flag |= (1 << number);
            // 找出最大值与最小值
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            // 判断最大值与最小值的差是否小于5
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}