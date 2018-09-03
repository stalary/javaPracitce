/**
 * @(#)HuaWeiPhone.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.method;

/**
 * HuaWeiPhone
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class HuaWeiPhone implements Phone {
    @Override
    public void desc() {
        System.out.println("I am huawei Phone");
    }
}