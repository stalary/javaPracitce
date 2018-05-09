/**
 * @(#)Test.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.callback;

/**
 * Test
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class Test {

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setCallInterface(() -> System.out.println("this is the client printName method"));
        caller.call();

    }
}