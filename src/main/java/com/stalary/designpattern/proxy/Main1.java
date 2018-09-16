/**
 * @(#)Main1.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

/**
 * com.stalary.algorithm.aiqiyi.Main1
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class Main1 {

    public static void main(String[] args) {
        Zoo zoo = new ZooImpl();
        Zoo proxy = (Zoo) new ProxyFactory(zoo).getProxyInstance();
        proxy.enter(new User(1, "stalary"));
        proxy.enter(new User(2, "hawk"));
        proxy.enter(new User(3, "claire"));
    }
}