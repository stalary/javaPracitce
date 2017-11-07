package com.stalary.object;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/28
 */
public class User {

    private String name;
    private Integer age;
    private String sex;

    public User() {
    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + "name: " + name + " " + "age: " + age + " " + "sex: " + sex;
    }
}
