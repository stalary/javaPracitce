/**
 * @(#)A.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.callback;

/**
 * A
 *
 * @author lirongqian
 * @since 26/12/2017
 */
public class A {

    public void method(CallBackA a){
        new Thread(() -> a.print("A")).start();
    }


    public interface  CallBackA{
        void print(String str);
    }
}