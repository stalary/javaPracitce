/**
 * @(#)PhoneFactory1.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.abstact;

/**
 * PhoneFactory1
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class PhoneFactory1 implements Factory{
    @Override
    public IOS createIOS() {
        return new Iphone();
    }

    @Override
    public Android createAndroid() {
        return new HuaWei();
    }
}