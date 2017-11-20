/**
 * @(#)KeyboardRow.java, 2017-11-18.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.stream.Stream;

/**
 * KeyboardRow
 *
 * 判断一个单词是否全部由键盘上的一行组成
 * @author lirongqian
 * @since 2017/11/18
 */
public class KeyboardRow {

    public static void main(String[] args) {
        String[] words = new String[] {
                "Hello", "Alaska", "Dad", "Peace"
        };
        System.out.println(Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new));
    }
}