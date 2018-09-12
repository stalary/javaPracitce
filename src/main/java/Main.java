/**
 * @(#)Main1.java, 2018-09-09.
 * <p>
 * Copyright 2018 Stalary.
 */

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/09
 */
public class Main {

    public static void main(String[] args) {
        String str = "12346";
        System.out.println(parseInt(str));
    }

    public static int parseInt(String num) {
        char[] chars = num.toCharArray();
        int index = 1;
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += index * (chars[i] - '0');
            index *= 10;
        }
        return sum;
    }

}