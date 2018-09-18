/**
 * @(#)Applicant.java, 2018-09-17.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.chain;

/**
 * Applicant
 *
 * @author lirongqian
 * @since 2018/09/17
 */
public class Applicant {

    private Interviewer interviewer;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }
}