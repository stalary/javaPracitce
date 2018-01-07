/**
 * @(#)FirstAppearingOnce.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FirstAppearingOnce
 *
 * 找出字符流中第一个只出现一次的字符
 * @author lirongqian
 * @since 2018/01/07
 */
public class FirstAppearingOnce {

    Map<Character, Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char out : map.keySet()) {
            if (map.get(out) == 1) {
                return out;
            }
        }
        return '#';
    }
}