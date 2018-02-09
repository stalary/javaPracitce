/**
 * @(#)Test.java, 2018-01-30.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.protostuff;

import com.alibaba.fastjson.JSON;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/01/30
 */
public class Test {

    public static void main(String[] args) throws IOException {


        Person.Children children = new Person.Children("hawk", "man", 21);
        Person stalary = new Person("stalary", "man", 22, 84.5);

        protoStuff(stalary);
        fastJson(stalary);
        protoBuf();
//        hand();
    }

    private static void protoStuff(Person person) {
        long start = System.currentTimeMillis();
        Person newPerson = new Person();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<Person> schema = RuntimeSchema.createFrom(Person.class);
        // 序列化
        byte[] bytes = ProtostuffIOUtil.toByteArray(person, schema, buffer);
        System.out.println(Arrays.toString(bytes));
        // 反序列化
        ProtostuffIOUtil.mergeFrom(bytes, newPerson, schema);
        System.out.println(newPerson);
        System.out.println("protoStuff time: " + (System.currentTimeMillis() - start));
    }

    private static void fastJson(Person person) {
        long start2 = System.currentTimeMillis();
        Person new2 = new Person();
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
        new2 = JSON.parseObject(jsonString, Person.class);
        System.out.println(new2);
        System.out.println("fastJson time: " + (System.currentTimeMillis() - start2));
    }

    private static void protoBuf() throws IOException {
        long start = System.currentTimeMillis();
        PersonProtos.Person.Builder builder = PersonProtos.Person.newBuilder();
        builder.setAge(22)
                .setName("stalary")
                .setSex("man")
                .setScore(84.5);
        PersonProtos.Person person = builder.build();
        // 序列化
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        person.writeTo(output);
        byte[] byteArray = output.toByteArray();
        System.out.println(Arrays.toString(byteArray));
        // 反序列化
        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
        PersonProtos.Person person1 = PersonProtos.Person.parseFrom(input);
        System.out.println(person1);
        System.out.println("protoBuf time: " + (System.currentTimeMillis() - start));
    }

    private static void hand() {
        HandWritingsProtos.HandWritingsPB.Builder pb = HandWritingsProtos.HandWritingsPB.newBuilder();
        HandWritingsProtos.HandWritingsPB.PointPB.Builder pointPB = HandWritingsProtos.HandWritingsPB.PointPB.newBuilder();
        pointPB.setX(1)
                .setY(2)
                .setP(1.0f)
                .setS(2.0f)
                .setW(3.0f).build();
        HandWritingsProtos.HandWritingsPB.HandWritingPB.Builder handPB = HandWritingsProtos.HandWritingsPB.HandWritingPB.newBuilder();
        handPB.setBottom(1)
                .setLeft(2)
                .setRight(3)
                .setTop(4)
                .addPoint(pointPB);
        pb.addWriting(handPB).build();

        System.out.println(pb);

    }
}