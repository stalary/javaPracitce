/**
 * @(#)ByteToObject.java, 2017-11-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * ByteToObject
 *
 * @author lirongqian
 * @since 2017/11/7
 */
public class ByteToObject {

    public static void main(String[] args) throws Exception {
        // ObjectToByte
        // 初始化对象
        Person stalary = new Person("stalary", 18);
        // 定义字节数组输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        // 将对象写入到字节数组进行输出，进行序列化
        out.writeObject(stalary);
        byte[] stalaryByte = os.toByteArray();
        for (byte outPut : stalaryByte) {
            System.out.print(outPut + " ");
        }
        System.out.println();

        // ByteToObject
        // 字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(stalaryByte);
        // 执行反序列化，从流中读取数据
        ObjectInputStream in = new ObjectInputStream(is);
        Person person = (Person) in.readObject();
        System.out.println(person);
    }


    @Data
    @AllArgsConstructor
    public static class Person implements Serializable {
        String name;
        int age;

    }
}