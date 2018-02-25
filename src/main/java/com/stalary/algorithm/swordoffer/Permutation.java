/**
 * @(#)Permutation.java, 2017-12-18.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Permutation
 * <p>
 * 输出字符串的全排列
 *
 * @author lirongqian
 * @since 2017/12/18
 */
public class Permutation {

    public static void main(String[] args) {

    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    public void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                // 存入list之后再交换回来
                swap(cs, i, j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}