/**
 * @(#)ReverseVowelsOfAString345.java, 2017-12-24.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * ReverseVowelsOfAString345
 *
 * 只反转两个元音字母
 * @author lirongqian
 * @since 24/12/2017
 */
public class ReverseVowelsOfAString345 {

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString345().reverseVowels("hello"));
    }

    /**
     * 可以使用两个指针，当遇到元音字母进行交换
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    /**
     * 先使用set存储元音字母，然后遇到元音字母就存入栈中，最后弹出栈并加上其他的元素
     * @param s
     * @return
     */
    public String reverseVowels1(String s) {
        if(s == null || s.length()==0){
            return s;
        }
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        // reverse the  vowels while popping up
        Stack<Character> vStack = new Stack<>();
        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                vStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                sb.append(vStack.pop());
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}