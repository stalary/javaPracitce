/**
 * @(#)BitCharacters.java, 2017-11-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * BitCharacters
 *
 * 判断一个数组是否只有10或者11或者0组成，并且0结尾
 * @author lirongqian
 * @since 2017/11/24
 */
public class BitCharacters717 {

    public static void main(String[] args) {
        int[] bits = new int[]{
                1, 0, 0
        };
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return i == bits.length - 1;
    }
}