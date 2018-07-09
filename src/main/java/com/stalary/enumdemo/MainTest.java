/**
 * @(#)MainTest.java, 2018-07-09.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.enumdemo;

/**
 * MainTest
 *
 * @author lirongqian
 * @since 2018/07/09
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println(Test.getInstance() == Test.Instance);
    }
}