package com.stalary.date;

import java.util.Date;

/**
 * @author Stalary
 * @description
 * @date 2017/10/15
 */
public class DateTest {

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        p.getEnd().setYear(2);
        System.out.println(p.getEnd());
    }
}
