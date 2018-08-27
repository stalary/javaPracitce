/**
 * @(#)ZooProxy.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

/**
 * ZooProxy
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class ZooProxy implements Zoo {

    private Integer num = 1;

    private static final Integer MAX_NUM = 2;

    /** 目标对象 **/
    private Zoo zoo;

    public ZooProxy(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void enter(User user) {
        if (num <= MAX_NUM) {
            // 执行之前
            System.out.println(user + " can enter");
            num++;
            zoo.enter(user);
            // 执行之后
            System.out.println(user + " left");
        } else {
            System.out.println(user + " is not allowed to enter");
        }
    }
}