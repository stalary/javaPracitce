
package com.stalary.algorithm.leetcode;

import java.util.LinkedList;

/**
 * BaseballGame682
 *
 * 按符号进行运算，数字就相加，C是减去前一个数字，D是加上上一个数字的两倍，+是加上上一个数字和倒数第二个数字
 * @author lirongqian
 * @since 2017/11/20
 */
public class BaseballGame682 {

    public static void main(String[] args) {
        String[] ops = new String[]{
                "5", "2", "C", "D", "+"
        };
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (String op : ops) {
            if ("C".equals(op)) {
                sum -= list.removeLast();
            } else if ("D".equals(op)) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            } else if ("+".equals(op)) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            } else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
    }
}