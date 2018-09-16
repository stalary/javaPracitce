/**
 * @(#)Main.java, 2018-09-14.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.memento;

import java.time.LocalDateTime;

/**
 * com.stalary.algorithm.aiqiyi.Main1
 *
 * @author lirongqian
 * @since 2018/09/14
 */
public class Main {

    public static void main(String[] args) {
        Role role = new Role("1.0", LocalDateTime.now(), "hello world");
        System.out.println("修改前：" + role);
        Manager manager = new Manager();
        manager.setBean(role.setBean());
        role.setCode("test update");
        role.setTag("1.1");
        role.setTime(LocalDateTime.now());
        System.out.println("修改后：" + role);
        role.recover(manager.getBean());
        System.out.println("回滚后：" + role);
    }
}