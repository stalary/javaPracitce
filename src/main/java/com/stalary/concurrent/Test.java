package com.stalary.concurrent;

import com.sun.org.apache.regexp.internal.RE;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/20
 */

public class Test {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        BigInteger[] bigIntegers = new BigInteger[] {BigInteger.TEN,BigInteger.ONE};
        OneValueCache oneValueCache = new OneValueCache(BigInteger.ONE,bigIntegers);
        for(BigInteger bigInteger : oneValueCache.getLastFactors(BigInteger.ONE)) {
            System.out.println(bigInteger);
        }
    }
}

class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(lastFactors,lastFactors.length);
    }

    public BigInteger[] getLastFactors(BigInteger i) {
        if(lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors,lastFactors.length);
        }

    }
}
