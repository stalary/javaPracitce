/**
 * @(#)Handler.java, 2018-09-17.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.chain;

/**
 * Handler
 *
 * @author lirongqian
 * @since 2018/09/17
 */
public abstract class Interviewer {

    public String name;

    Interviewer next;

    public Interviewer(String name) {
        this.name = name;
    }

    public void setNext(Interviewer interviewer) {
        this.next = interviewer;
    }

    public abstract void handleApplicant(Applicant applicant);
}