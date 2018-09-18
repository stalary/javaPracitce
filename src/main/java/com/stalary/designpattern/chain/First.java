/**
 * @(#)First.java, 2018-09-17.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.chain;

/**
 * First
 *
 * @author lirongqian
 * @since 2018/09/17
 */
public class First extends Interviewer {
    public First(String name) {
        super(name);
    }

    @Override
    public void handleApplicant(Applicant applicant) {
        System.out.println("I am " + name + " interviewer");
        if (applicant.getScore() < 5) {
            System.out.println("The First Interview failed");
        } else {
            System.out.println("Enter the next interview");
            if (this.next != null) {
                this.next.handleApplicant(applicant);
            }
        }
    }
}