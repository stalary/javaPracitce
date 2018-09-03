/**
 * @(#)HuaWeiFactory.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.method;

/**
 * HuaWeiFactory
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class HuaWeiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}