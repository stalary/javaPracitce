/**
 * @(#)Person.java, 2018-01-30.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.protostuff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 *
 * @author lirongqian
 * @since 2018/01/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private String sex;

    private int age;

    private double score;

    private String favorite;

    private String likeFood;

    private int grade;

    private Children children;

    public Person(String name, String sex, int age, String favorite, String likeFood, int grade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.favorite = favorite;
        this.likeFood = likeFood;
        this.grade = grade;
    }

    public Person(String name, String sex, int age, double score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Children {

        private String name;

        private String sex;

        private int age;
    }
}