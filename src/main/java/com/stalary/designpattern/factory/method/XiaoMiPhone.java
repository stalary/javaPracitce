/**
 * @(#)MiPhone.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.method;

/**
 * XiaoMiPhone
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class XiaoMiPhone implements Phone {
    @Override
    public void desc() {
        System.out.println("I am xiaomi Phone");
    }
}