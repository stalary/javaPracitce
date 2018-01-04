/**
 * @(#)duplicate.java, 2018-01-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * duplicate
 *
 * 返回第一个重复数字
 * @author lirongqian
 * @since 03/01/2018
 */
public class duplicate {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int out : numbers) {
            if (set.contains(out)) {
                duplication[0] = out;
                return true;
            }
            set.add(out);
        }
        return false;
    }
}