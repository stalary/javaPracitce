/**
 * @(#)Period.java, 2018-06-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.date;

import java.util.Date;

/**
 * Period
 *
 * @author lirongqian
 * @since 2018/06/05
 */
public class Period {

    private final Date start;

    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("test");
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}