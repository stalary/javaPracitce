/**
 * @(#)Jump.java, 2017-12-04.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;
/**
 * Jump
 *
 * @author lirongqian
 * @since 2017/12/4
 */
public class Jump {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    public static int JumpFloorII(int target) {
        if (target <= 1) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = 2 * arr[i - 1];
        }
        return arr[target];
    }
}