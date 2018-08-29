/**
 * @(#)ZooEnum.java, 2018-08-27.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.singleton;

/**
 * ZooEnum
 *
 * @author lirongqian
 * @since 2018/08/27
 */
public enum ZooEnum {

    Instance;


    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}