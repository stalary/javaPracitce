package com.stalary.algorithm.didi;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer[] num = new Integer[3];
        Scanner in = new Scanner(System.in);
        num[0] = in.nextInt();
        num[1] = in.nextInt();
        num[2] = in.nextInt();
        Arrays.sort(num, Comparator.reverseOrder());
        BigInteger multiply = c(num[0] + 1, num[1]).multiply(c(num[0] + num[1] + 1, num[2]));
        System.out.println(multiply.longValue() - 6);
    }

    public static BigInteger c(int a, int b) {
        BigInteger temp = BigInteger.ZERO;
        BigInteger sum = BigInteger.ONE;
        for (int i = 0; i < b; i++) {
            BigInteger temp1 = BigInteger.valueOf(a);
            BigInteger t2 = temp1.subtract(temp);
            BigInteger t1 = sum.multiply(t2);
            sum = t1.divide(temp.add(BigInteger.ONE));
            temp = temp.add(BigInteger.ONE);
        }
        return sum;

    }
}