/**
 * @(#)Management.java, 2018-09-14.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.memento;

/**
 * Manager
 *
 * @author lirongqian
 * @since 2018/09/14
 */
public class Manager {

    private Bean bean;

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }
}