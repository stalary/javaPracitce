/**
 * @(#)ProxyFactory.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * ProxyFactory
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("动态代理开始执行");
                    Object value = method.invoke(target, args);
                    System.out.println("动态代理执行完毕");
                    return value;
                }
        );
    }
}