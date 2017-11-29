/**
 * @(#)BestTimeToBuyAndSellStockII122.java, 2017-11-29.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * BestTimeToBuyAndSellStockII122
 *
 * @author lirongqian
 * @since 2017/11/29
 */
public class BestTimeToBuyAndSellStockII122 {

    public static void main(String[] args) {
        int[] prices = new int[] {
                2, 3, 5, 1, 7
        };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int differ = prices[i + 1] - prices[i];
            if (differ > 0) {
                sum += differ;
            }
        }
        return sum;
    }
}