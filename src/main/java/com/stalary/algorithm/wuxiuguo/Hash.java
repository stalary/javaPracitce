/**
 * @(#)Hash.java, 2018-06-22.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

import java.util.*;

/**
 * Hash
 *
 * @author lirongqian
 * @since 2018/06/22
 */
public class Hash {

    public static void main(String[] args) {
        String[] strings = new String[]{"for", "switch", "if", "case", "else", "static", "union"};
        System.out.println(cal(strings));
    }

    public static Map<Integer, Set<String>> cal(String[] strings) {
        Map<Integer, Set<String>> result = new HashMap<>();
        for (String str : strings) {
            int temp = strMod(str);
            if (result.containsKey(temp)) {
                // 当存在时，使用开散列的方法解决冲突
                Set<String> stringSet = result.get(temp);
                stringSet.add(str);
            } else {
                // 不存在时，存储当前元素
                Set<String> set = new HashSet<>();
                set.add(str);
                result.put(temp, set);
            }
        }
        return result;
    }

    public static int strMod(String str) {
        // 将字符串转化为数字
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c - 'a';
        }
        return mod(sum);
    }

    public static int mod(int num) {
        // hash取模
        return num % 7;
    }
}