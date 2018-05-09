
package com.stalary.algorithm.leetcode;

/**
 * ExcelSheetColumnNumber171
 *
 * 输入一个由大写字母组成的字符串，A->1,Z->26,AA->27
 * @author lirongqian
 * @since 2017/11/29
 */
public class ExcelSheetColumnNumber171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + s.charAt(i) - 'A' + 1;
        }
        return sum;
    }

}