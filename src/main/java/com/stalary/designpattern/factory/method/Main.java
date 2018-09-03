/**
 * @(#)Main.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.method;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class Main {

    public static void main(String[] args) {
        PhoneFactory factory;
        factory = new AppleFactory();
        Phone apple = factory.createPhone();
        apple.desc();
        factory = new HuaWeiFactory();
        Phone huawei = factory.createPhone();
        huawei.desc();
        factory = new XiaoMiFactory();
        Phone xiaomi = factory.createPhone();
        xiaomi.desc();
    }
}