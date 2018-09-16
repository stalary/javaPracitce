/**
 * @(#)User.java, 2018-09-15.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.observer;

/**
 * User
 *
 * @author lirongqian
 * @since 2018/09/15
 */
public class User implements Observer {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        show();
    }

    public void show() {
        System.out.println(this.name + " receive message {" + this.message + "}");
    }
}