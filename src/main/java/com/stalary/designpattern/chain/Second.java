/**
 * @(#)Second.java, 2018-09-17.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.chain;

/**
 * Second
 *
 * @author lirongqian
 * @since 2018/09/17
 */
public class Second extends Interviewer {

    public Second(String name) {
        super(name);
    }

    @Override
    public void handleApplicant(Applicant applicant) {
        System.out.println("I am " + name + " interviewer");
        if (applicant.getScore() < 5) {
            System.out.println("The Second Interview failed");
        } else {
            System.out.println("You've already passed all the interviews");
        }
    }
}