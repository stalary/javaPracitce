/**
 * @(#)PandaZoo.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

/**
 * ZooImpl
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class ZooImpl implements Zoo {
    @Override
    public void enter(User user) {
        System.out.println(user + " enter ZooImpl");
    }
}