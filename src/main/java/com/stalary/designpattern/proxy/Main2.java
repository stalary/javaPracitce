/**
 * @(#)Main2.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class Main2 {

    public static void main(String[] args) {
        NormalZoo target = new NormalZoo();
        NormalZoo proxy = (NormalZoo) new ProxyCGLIB(target).getProxyInstance();
        proxy.enter(new User(1, "stalary"));
        proxy.enter(new User(2, "hawk"));
        proxy.enter(new User(3, "claire"));
        StringBuilder sb = new StringBuilder();

    }
}