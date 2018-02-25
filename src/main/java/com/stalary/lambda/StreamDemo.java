package com.stalary.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * StreamDemo
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class StreamDemo {

    public static void main(String[] args) {
        // 求出年龄最大是多少
        List<Person> list = Arrays.asList(
                new Person("stalary", 22, "man",
                        Arrays.asList(new Person.Score("java", 97),
                                new Person.Score("linux", 77),
                                new Person.Score("oracle", 87))),
                new Person("claire", 20, "woman",
                        Arrays.asList(new Person.Score("java", 87),
                                new Person.Score("linux", 82),
                                new Person.Score("oracle", 88))),
                new Person("hawk", 21, "man",
                        Arrays.asList(new Person.Score("java", 77),
                                new Person.Score("linux", 75),
                                new Person.Score("oracle", 77))));
        Person person = list.stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println(person);
        // 找出名字长度大于4的人名
        Set<String> set = list.stream()
                .filter(p -> p.getName().length() > 4)
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println(set);
        // 找出有人成绩大于90的科目
        Set<String> scores = list.stream()
                .flatMap(p -> p.getScores().stream())
                .filter(s -> s.grade > 90)
                .map(Person.Score::getProject)
                .collect(Collectors.toSet());
        System.out.println(scores);
        IntSummaryStatistics intSummaryStatistics = list.get(0).getScores().stream().mapToInt(Person.Score::getGrade).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMin());

        // 按性别分组
        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect);

        // peek，可以继续stream，使用foreach会停止stream
        Set<Person.Score> collect1 = list.get(0).getScores()
                .stream()
                .peek(score -> score.setGrade(0))
                .collect(Collectors.toSet());

        System.out.println(collect1);
    }

    @Data
    @AllArgsConstructor
    private static class Person {
        private String name;
        private Integer age;
        private String sex;
        private List<Score> scores;

        @Data
        @AllArgsConstructor
        static class Score {
            private String project;
            private Integer grade;
        }
    }
}