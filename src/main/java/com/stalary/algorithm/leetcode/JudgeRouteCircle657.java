/**
 * @(#)JudgeRouteCircle657.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * JudgeRouteCircle657
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class JudgeRouteCircle657 {

    public static void main(String[] args) {
        String str = "LL";
        System.out.println(judgeCircle(str));
    }

    public static boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int x = 0, y = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }

}