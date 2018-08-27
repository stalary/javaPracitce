/**
 * @(#)ProxyCGLIB.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ProxyCGLIB
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class ProxyCGLIB implements MethodInterceptor {

    private Object target;

    public ProxyCGLIB(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始执行");
        Object value = method.invoke(target, args);
        System.out.println("cglib执行完毕");
        return value;
    }
}