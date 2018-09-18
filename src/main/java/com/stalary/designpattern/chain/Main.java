/**
 * @(#)Main.java, 2018-09-17.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.chain;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/17
 */
public class Main {

    public static void main(String[] args) {
        Applicant applicant = new Applicant();
        applicant.setScore(7);
        Interviewer interviewer1 = new First("stalary");
        Interviewer interviewer2 = new Second("claire");
        interviewer1.setNext(interviewer2);
        interviewer1.handleApplicant(applicant);
        System.out.println("-------------------");
        Applicant loser = new Applicant();
        loser.setScore(1);
        interviewer1.handleApplicant(loser);
    }
}