/**
 * @(#)Person.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.builder;

/**
 * Person
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public class Person {

    private final String name;

    private final int age;

    private final String sex;

    private final String address;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {

        private final String name;

        private final String sex;

        private int age;

        private String address;

        public Builder(String name, String sex) {
            if (name == null || sex == null) {
                throw new IllegalArgumentException("name and sex can not be null");
            }
            if (!sex.equals("man") && !sex.equals("woman")) {
                throw new IllegalArgumentException("sex input error!");
            }
            this.name = name;
            this.sex = sex;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}