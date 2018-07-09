/**
 * @(#)Test.java, 2018-07-09.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.callback;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/07/09
 */
public class Test {

    public static void main(String[] args) {
        Producer producer = new TestProducer();
        producer.send("hello", str -> {
            if (str.contains("stalary")) {
                System.out.println("good");
            } else if (str.contains("hawk")) {
                System.out.println("not bad");
            } else {
                System.out.println(str + " error");
            }
        });
    }
}