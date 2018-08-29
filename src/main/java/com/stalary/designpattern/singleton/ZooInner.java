/**
 * @(#)ZooInner.java, 2018-08-27.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.singleton;

/**
 * ZooInner
 *
 * @author lirongqian
 * @since 2018/08/27
 */
public class ZooInner {

    private ZooInner() {
    }

    public static ZooInner getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ZooInner INSTANCE = new ZooInner();
    }
}