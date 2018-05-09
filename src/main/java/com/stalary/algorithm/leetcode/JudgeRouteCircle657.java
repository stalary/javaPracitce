
package com.stalary.algorithm.leetcode;

/**
 * JudgeRouteCircle657
 *
 * 判断做的运动是否能够回到原点
 * R向右，L向左，U向上，D向下
 * @author lirongqian
 * @since 2017/11/15
 */
public class JudgeRouteCircle657 {

    public static void main(String[] args) {
        String str = "LL";
        System.out.println(judgeCircle(str));
    }

    public static boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int x = 0, y = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }

}