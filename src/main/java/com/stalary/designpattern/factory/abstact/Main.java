/**
 * @(#)Main.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.abstact;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = new PhoneFactory1();
        Android android1 = factory.createAndroid();
        android1.desc();
        IOS ios = factory.createIOS();
        ios.desc();
        factory = new PhoneFactory2();
        Android android2 = factory.createAndroid();
        android2.desc();
    }
}