/**
 * @(#)TimerDemo.java, 2017-12-13.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import kafka.utils.timer.TimerTaskEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerDemo
 *
 * @author lirongqian
 * @since 2017/12/13
 */
public class TimerDemo extends TimerTask{

    private static Timer timer = new Timer(true);

    public static void main(String[] args) throws ParseException {
        TimerDemo timerDemo = new TimerDemo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2017-12-13 15:25:00";
        Date newDate = sdf.parse(date);
        timer.schedule(timerDemo, 2000);
    }

    @Override
    public void run() {
        System.out.println("timer start: " + new Date());
    }
}
