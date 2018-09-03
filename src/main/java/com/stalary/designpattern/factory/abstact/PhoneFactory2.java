/**
 * @(#)PhoneFactory2.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.abstact;

/**
 * PhoneFactory2
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class PhoneFactory2 implements Factory {
    @Override
    public IOS createIOS() {
        return new Iphone();
    }

    @Override
    public Android createAndroid() {
        return new XiaoMi();
    }
}