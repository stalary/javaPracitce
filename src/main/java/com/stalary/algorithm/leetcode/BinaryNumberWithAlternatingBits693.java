
package com.stalary.algorithm.leetcode;

/**
 * BinaryNumberWithAlternatingBits693
 * <p>
 * 输入一个正数，转化为二进制，判断是否为跳跃式
 *
 * @author lirongqian
 * @since 2017/11/22
 */
public class BinaryNumberWithAlternatingBits693 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits1(5));
    }

    public static boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 因为题目说输入为正数，所以可以利用正则表达式来进行判断
     */
    public static boolean hasAlternatingBits1(int n) {
        return Integer.toBinaryString(n).matches("(10)*1?");
    }
}