/**
 * @(#)ThisDemo.java, 2018-02-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.object;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ThisDemo
 *
 * @author lirongqian
 * @since 2018/02/06
 */
@Data
public class ThisDemo extends Father {

    private int age;

    private String name;

    private static ThisDemo obj;

    public ThisDemo(int age) {
        this.age = age;
    }

    public ThisDemo() {
        this.age = 18;
        obj = this;
    }

    public static void write() {
        new ThisDemo(21, "stalary");
    }

    public static void main(String[] args) {
//        System.out.println(new ThisDemo(21).setName("stalary"));
        new ThisDemo(12);
//        System.out.println(ThisDemo.obj);
    }

    public ThisDemo(int age, String name) {
        this(age);
        System.out.println(name + "年龄为：" + age);
    }

    public ThisDemo add(int age) {
        this.age = age;
        return this;
    }

    public ThisDemo setName(String name) {
        this.name = name;
        return this;
    }
}

class Father {

    public Father() {
        System.out.println("调用无参构造函数");
    }

    public Father(int age) {
        System.out.println("调用含参构造函数");
    }
}

@Data
class FinalReferenceEscape{

    final int i;

    int age;

    static FinalReferenceEscape object;

    public FinalReferenceEscape() {
        i = 1;
        this.age = 18;
        object = this;
    }

    public static void write() {
        new FinalReferenceEscape();
    }

    public static void read() {
        if (object != null) {
            System.out.println(object.i);
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.newCondition();
        ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
        lock1.readLock();
        lock1.writeLock();

        new Thread(FinalReferenceEscape::write).start();
        new Thread(FinalReferenceEscape::read).start();
        System.out.println(FinalReferenceEscape.object);
        Map<String, Integer> map = new HashMap<>();
        map.put("stalary", 18);
        Integer stalary = map.put("stalary", 22);
        System.out.println(stalary);


    }

}