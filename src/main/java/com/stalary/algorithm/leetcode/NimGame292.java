/**
 * @(#)NimGame292.java, 2017-11-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * NimGame292
 *
 * 此题实际为巴什博弈！
 * @author lirongqian
 * @since 2017/11/22
 */
public class NimGame292 {

    public static void main(String[] args) {
        System.out.println(canWinNim(5));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}