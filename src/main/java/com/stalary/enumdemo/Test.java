/**
 * @(#)Test.java, 2018-06-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.enumdemo;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/06/05
 */
public enum Test {
    Instance;

    Test() {

    }

    public static Test getInstance() {
        return Instance;
    }
}