package com.stalary.comparator;

import java.util.*;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/5
 */
public class ComparatorAndComparableSort {

    public static void main(String[] args) {
        User user = new User("stalary","男",21);
        User user1 = new User("zyw","女",20);
        User user2 = new User("hawk","男",22);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        ComparatorAndComparableSort t = new ComparatorAndComparableSort();
        System.out.println("初始顺序");
        for(User u : userList) {
            System.out.println(u);
        }
        //通过Comparator对年龄排序
        System.out.println("对年龄降序排序");
        Collections.sort(userList,t.new sortAge());
        for(User u : userList) {
            System.out.println(u);
        }

        //通过Comparator对姓名排序
        System.out.println("对姓名升序排序");
        Collections.sort(userList,t.new sortByName(true));
        for(User u : userList) {
            System.out.println(u);
        }

        User users[]= {new User("stalary", "男", 21),
                new User("zyw", "男", 19),
                new User("hawk", "男", 22),
        };
        //使用comparable对年龄排序
        Arrays.sort(users);
        System.out.println("使用comparable对年龄排序");
        for(User u : users) {
            System.out.println(u);
        }
        //使用lambda对人名排序
        System.out.println("lambda对人名排序");
        Arrays.sort(users, Comparator.comparing(User::getName,
                Comparator.comparingInt(String::length)));
        for(User u : users) {
            System.out.println(u);
        }
    }

    private final class sortByName implements Comparator<User> {

        boolean is_Ascend;

        public sortByName(boolean b) {
            is_Ascend = b;//当is_Ascend为true时，升序排序
        }

        @Override
        public int compare(User o1, User o2) {
            if(is_Ascend) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        }
    }

    private final class sortAge implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            Integer a = o1.getAge();
            Integer b = o2.getAge();
            if(a > b) {
                return -1;
            } else if(a.equals(b)) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
class User implements Comparable<User> {
    private String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return getClass().getSimpleName() + "[name=" + name + ",age=" + age + ",sex=" + sex + "]";
    }

    @Override
    public int compareTo(User o) {
        if(this.age > o.getAge()) {
            return -1;
        } else if(this.age < o.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}
