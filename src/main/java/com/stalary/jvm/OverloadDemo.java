/**
 * @(#)Overload.java, 2017-12-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.jvm;


import java.io.Serializable;

/**
 * Overload
 *
 * @author lirongqian
 * @since 21/12/2017
 */
public class OverloadDemo {

    public void say(char a) {
        System.out.println("char: " + a);
    }

    public void say(int a) {
        System.out.println("int: " + a);
    }

    public void say(long a) {
        System.out.println("long: " + a);
    }

    public void say(float a) {
        System.out.println("float: " + a);
    }

    public void say(double a) {
        System.out.println("double: " + a);
    }

    public void say(Character a) {
        System.out.println("Character: " + a);
    }

    public void say(Comparable a) {
        System.out.println("Comparable: " + a);
    }

    public void say(Serializable a) {
        System.out.println("Serializable: " + a);
    }

    public void say(Object a) {
        System.out.println("Object: " + a);
    }

    public void say(char... a) {
        System.out.println("char...: " + a);
    }


    public static void main(String[] args) {
        OverloadDemo o = new OverloadDemo();
        o.say('a');
    }
}