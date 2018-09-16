/**
 * @(#)Main1.java, 2018-08-27.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.singleton;

/**
 * com.stalary.algorithm.aiqiyi.Main1
 *
 * @author lirongqian
 * @since 2018/08/27
 */
public class Main1 {


    public static void main(String[] args) {
        ZooInner zoo1 = ZooInner.getInstance();
        ZooInner zoo2 = ZooInner.getInstance();
        System.out.println(zoo1);
        System.out.println(zoo2);
    }
}