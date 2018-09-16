/**
 * @(#)Main.java, 2018-09-13.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.flyweight;

/**
 * com.stalary.algorithm.aiqiyi.Main1
 *
 * @author lirongqian
 * @since 2018/09/13
 */
public class Main {

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        Person person = factory.getPerson("stalary");
        person.introduce("第一次获取");
        person = factory.getPerson("hawk");
        person.introduce("第二次获取");
        person = factory.getPerson("stalary");
        person.introduce("第三次获取");
        System.out.println("当前对象数量:" + factory.getCount());
    }
}