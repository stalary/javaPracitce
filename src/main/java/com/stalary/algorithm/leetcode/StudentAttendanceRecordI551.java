/**
 * @(#)StudentAttendanceRecordI551.java, 2017-12-11.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

/**
 * StudentAttendanceRecordI551
 *
 * 给定一个字符串，如果不包含超过一个A或者超过两个连续的L，则返回true
 * @author lirongqian
 * @since 2017/12/11
 */
public class StudentAttendanceRecordI551 {

    public static void main(String[] args) {
        String s = "LLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
            if (i >= 2 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用正则表达式
     */
    public static boolean checkRecord1(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}