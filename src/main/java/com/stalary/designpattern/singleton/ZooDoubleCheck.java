/**
 * @(#)ZooDoubleCheck.java, 2018-08-27.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.singleton;

/**
 * ZooDoubleCheck
 *
 * @author lirongqian
 * @since 2018/08/27
 */
public class ZooDoubleCheck {

    private static volatile ZooDoubleCheck instance;

    private ZooDoubleCheck() {
        // 防止通过反射调用实例化
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static ZooDoubleCheck getInstance() {
        // 使用局部变量会加快速度
        ZooDoubleCheck check = instance;
        if (check == null) {
            synchronized (ZooDoubleCheck.class) {
                // 更新局部变量
                check = instance;
                if (check == null) {
                    // 双重检测都为null时进行实例化
                    instance = check = new ZooDoubleCheck();
                }
            }
        }
        return check;
    }
}