/**
 * @(#)One.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.yixin;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * One
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class One {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger w = in.nextBigInteger();
        BigInteger temp = n.modPow(w, BigInteger.valueOf(100003)).subtract(n.multiply(n.subtract(BigInteger.ONE).modPow(w.subtract(BigInteger.ONE), BigInteger.valueOf(100003))));
        System.out.println(temp.mod(BigInteger.valueOf(100003)));
    }
}