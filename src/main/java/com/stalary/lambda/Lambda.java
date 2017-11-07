package com.stalary.lambda;


import java.util.*;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/5
 */
public class Lambda {
    public static void main(String[] args) {
        String[] users = new String[] {"stalary","zyw","hawk"};
        System.out.println("排序前");
        System.out.println(Arrays.toString(users));

        //使用lambda表达式的缩写比较字符串的长度来进行排序
        Arrays.sort(users, Comparator.comparingInt(String::length));
        System.out.println("排序后");
        System.out.println(Arrays.toString(users));
        List<String> stringList = new ArrayList<>();
        stringList.add("stalary");
        stringList.add(null);
        stringList.add("zyw");
        stringList.add(null);
        stringList.add("hawk");
        System.out.println("处理前");
        System.out.println(stringList.toString());
        System.out.println("移除null");

        //移除null值
        stringList.removeIf(Objects::isNull);
        System.out.println(stringList.toString());
        System.out.println("移除hawk");

        //移除hawk
        stringList.removeIf(e -> e == "hawk");
        System.out.println(stringList.toString());

        //集合的排序
        User[] userLists = {
                new User("stalary","男",21),
                new User("zyw","女",20),
                new User("hawk","男",22),
        };
        List<User> userList = Arrays.asList(userLists);
        //使用lambda表达式进行排序
        userList.sort(Comparator.comparingInt((User::getAge)).reversed());
        System.out.println(userList);
    }

    static class User implements Comparable<User> {
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



}
