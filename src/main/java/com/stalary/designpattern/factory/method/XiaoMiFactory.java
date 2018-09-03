/**
 * @(#)XiaoMiFactory.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.method;

/**
 * XiaoMiFactory
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class XiaoMiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new XiaoMiPhone();
    }
}