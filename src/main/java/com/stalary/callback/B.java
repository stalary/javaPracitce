/**
 * @(#)B.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.callback;

/**
 * B
 *
 * @author lirongqian
 * @since 26/12/2017
 */
public class B  implements A.CallBackA{


    public static void main(String[] args) {

        B b = new B();
        A a = new A();
        a.method(b);
    }

    @Override
    public void print(String str) {
        System.out.println("B:"+str);
    }
}